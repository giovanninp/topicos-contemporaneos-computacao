package com.example.demo.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(Long id) {
		super(String.format("Could not find employee %d", id));
	}
}
