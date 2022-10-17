package com.school.bet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ticket")
public class Ticket {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @ManyToOne @JoinColumn(name = "competitor_id") Competitor competitor;
	private @ManyToOne @JoinColumn(name = "bet_id", nullable = false) Bet bet;
	private float baseValue;
	private float comission;
	private float paidValue;

	Ticket() {}
	
	public Ticket(Competitor competitor, Bet bet, Float baseValue, Float comission) {
		this.competitor = competitor;
		this.bet = bet;
		this.baseValue = baseValue;
		this.comission = comission;
	}
	
	public void setCompetitor(Competitor competitor) {
		this.competitor = competitor;
	}
	
	public void setBet(Bet bet) {
		this.bet = bet;
	}
	
	public void setBaseValue(Float baseValue) {
		this.baseValue = baseValue;
	}
	
	public void setComission(Float comission) {
		this.comission = comission;
	}
	
	public void setPaidValue(Float paidValue) {
		this.paidValue = baseValue;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public Competitor getCompetitor() {
		return this.competitor;
	}
	
	public float getComission() {
		return this.comission;
	}
	
	public float getBaseValue() {
		return this.baseValue;
	}
	
	public float getPaidValue() {
		return this.paidValue;
	}
}
