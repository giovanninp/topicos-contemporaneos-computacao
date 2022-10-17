package com.school.bet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="competitor")
public class Competitor {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	private Long registration;
	private Float performance;
	private Float standard;
	
	Competitor() {}
	
	public Competitor(Long registration, String name, float performance, float standard) {
		this.name = name;
		this.registration = registration;
		this.performance = performance;
		this.standard = standard;
	}
	
	public void setRegistration(Long registration) {
		this.registration = registration;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPerformance(Float performance) {
		this.performance = performance;
	}
	
	public void setStandard(Float standard) {
		this.standard = standard;
	}
	
	public Long getId() {
		return this.id;	
	}
	
	public Long getRegistration() {
		return this.registration;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Float getPerformance() {
		return this.performance;
	}
	
	public Float getStandard() {
		return this.standard;
	}
}
