package com.school.bet.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.bet.entities.Bet;
import com.school.bet.repositories.BetRepository;

@RestController
public class BetController {
	private final BetRepository betRepository;
	
	BetController(BetRepository betRepository) {
		this.betRepository = betRepository;
	}
	
	@GetMapping("/bets")
	List<Bet> all() {
		return this.betRepository.findAll();
	}
	
	@PostMapping("/bets")
	Bet newBet(@RequestBody Bet bet) {
		
	System.out.println(bet.toString());
		
		return this.betRepository.save(bet);
	}
	
	@GetMapping("/bets/{number}")
	Bet indexBet(@PathVariable long number) {
		Bet foundBet = this.betRepository.findByNumber(number).get(0);
		return foundBet;
	}
	
	
}
