package com.school.bet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.bet.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}

