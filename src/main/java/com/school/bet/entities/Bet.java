package com.school.bet.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.com.caelum.stella.validation.CNPJValidator;

@Entity
@Table(name="bet")
public class Bet {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String negotiatorRegister;
	private Date date;
	private @Column(unique = true) long number;
	private @OneToMany(mappedBy = "bet") Set<Ticket> tickets; 
	
	Bet() {}
	
	Bet(String negotiator, String dateString, long number) throws Exception {
		
		System.out.format("\nHello %s", negotiator);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.negotiatorRegister = negotiator;	
		this.date = dateFormat.parse(dateString);
		this.number = number;
	}
	
	public void setNegotiatorRegister(String negotiatorRegister) {
		CNPJValidator validator = new CNPJValidator();
		try {
			validator.assertValid(negotiatorRegister);
			this.negotiatorRegister = negotiatorRegister;
		} catch (Exception e) {
			throw new Error("Invalid negotiator entry");
		}
	}
	
	public void setDate(String dateString) throws Exception {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.date = dateFormat.parse(dateString);
		
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getNegotiatorRegister() {
		return this.negotiatorRegister;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public long getNumber() {
		return this.number;
	}
	
	public Set<Ticket> getTickets() {
		return this.tickets;
	}
}
