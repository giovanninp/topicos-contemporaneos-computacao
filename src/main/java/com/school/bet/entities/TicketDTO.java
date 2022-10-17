package com.school.bet.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketDTO {
	private @NotNull(message = "competitorId is required.") Long competitorId;
	private @NotNull(message = "betId is required.") Long betId;
	private @NotNull(message = "Undefined base value.") @Size(
			min=0,
			message = "Value lower the minimal."
	) Float baseValue;
	
	TicketDTO(Long competitorId, Long betId, Float baseValue) {
		this.competitorId = competitorId;
		this.betId = betId;
		this.baseValue = baseValue;
	}

	public Long getCompetitorId() {
		return competitorId;
	}

	public Long getBetId() {
		return betId;
	}
	
	public Float getBaseValue() {
		return this.baseValue;
	}
}
