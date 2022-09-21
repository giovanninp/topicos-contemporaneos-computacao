package com.example.demo.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String name;
	private String role;
	
	Employee() {}
	
	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	public Long geId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) o;
		return Objects.equals(this.id, employee.id) 
				&& Objects.equals(this.name, employee.name)
				&& Objects.equals(this.role, employee.role);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.role);
	}
	
	@Override
	public String toString() {
		return String.format(
				"Employee{id: %d,name:%s,role:%s}",
				this.id,
				this.name,
				this.role
				);
	}
}
