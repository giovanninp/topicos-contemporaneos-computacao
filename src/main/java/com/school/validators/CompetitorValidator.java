package com.school.validators;

public class CompetitorValidator {
	
	public static void isValidPerformance (float performance) {
		if(performance > 1) throw new Error("Performance cannot be greater than 1.");
		if(performance <= 0) throw new Error("Performance cannot be less tha 0.");
	}
	
	public static void isValidStandard(float standard) {
		if(standard <= 0) throw new Error("Standard value must be greater than 0.");
	}
}
