package com.school.bet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.bet.entities.Bet;

public interface BetRepository extends JpaRepository<Bet, Long> {
	@Query(value = "SELECT * FROM bet b WHERE b.number = :number", nativeQuery = true)
	List<Bet> findByNumber(Long number);	
}
