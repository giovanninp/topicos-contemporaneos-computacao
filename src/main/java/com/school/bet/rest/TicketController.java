package com.school.bet.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.bet.entities.Bet;
import com.school.bet.entities.Competitor;
import com.school.bet.entities.Ticket;
import com.school.bet.entities.TicketDTO;
import com.school.bet.repositories.BetRepository;
import com.school.bet.repositories.CompetitorRepository;
import com.school.bet.repositories.TicketRepository;

@RestController
public class TicketController {
	private final TicketRepository ticketRepository;
	private final CompetitorRepository competitorRepository;
	private final BetRepository betRepository;
	
	public TicketController(TicketRepository ticketRepository, CompetitorRepository competitorRepository, BetRepository betRepository) {
		this.ticketRepository = ticketRepository;
		this.competitorRepository = competitorRepository;
		this.betRepository = betRepository;
	}
	
	@GetMapping("/tickets")
	List<Ticket> all() {
		return this.ticketRepository.findAll();
	}
	
	@PostMapping("/tickets")
	Ticket newTicket(@RequestBody TicketDTO newTicketDTO) {
		
		Bet bet = this.betRepository
				.findById(newTicketDTO.getBetId())
				.map((curr) -> {
					return curr;
				})
				.orElseGet(() -> {
					return null;
				});
		
		Competitor competitor = this.competitorRepository
				.findById(newTicketDTO.getCompetitorId())
				.map((curr) -> {
					return curr;
				})
				.orElseGet(() -> {
					return null;
				});
	
		if(bet == null || competitor == null) return null;
		
		Float baseValue = newTicketDTO.getBaseValue();
		Float performance = competitor.getPerformance();
		Float standard = competitor.getStandard();
		
		Float comission = (float) (baseValue * 0.04 * (1 - performance)); 
		Float paidValue = (float) (standard * baseValue) / performance;
				
		Ticket ticket = new Ticket(
				competitor,
				bet,
				baseValue,
				comission
		);
		
		if(!(Float.isNaN(paidValue))) {
			ticket.setPaidValue(paidValue);			
		}
		
		return this.ticketRepository.save(ticket);
	}
	
	@GetMapping("/tickets/{id}")
	Ticket index(@PathVariable Long id) {
		return this.ticketRepository.findById(id).orElseGet(() -> {
			return null;
		});
	}
}
