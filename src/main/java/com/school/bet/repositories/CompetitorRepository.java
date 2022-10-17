package com.school.bet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.bet.entities.Competitor;

public interface CompetitorRepository extends JpaRepository<Competitor, Long> {
	@Query(value = "SELECT * FROM competitor c WHERE c.registration = :registration", nativeQuery = true)
	Competitor findByRegistration(Long registration);
}
