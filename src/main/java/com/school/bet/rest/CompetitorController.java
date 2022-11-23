package com.school.bet.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.bet.entities.Competitor;
import com.school.bet.repositories.CompetitorRepository;
import com.school.validators.CompetitorValidator;

@RestController
public class CompetitorController {
	private final CompetitorRepository repository;

	public CompetitorController(CompetitorRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/competitors")
	List<Competitor> all() {
		return repository.findAll();
	}

	@PostMapping("/competitors")
	Competitor newCompetitor(@RequestBody Competitor competitor) {
		try {
			CompetitorValidator.isValidPerformance(competitor.getPerformance());
			CompetitorValidator.isValidStandard(competitor.getStandard());
			return this.repository.save(competitor);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@GetMapping("/competitors/{id}")
	Optional<Competitor> index(@PathVariable Long id) {
		return repository.findById(id);
	}

	@GetMapping("/competitors/registration/{registration}")
	Competitor indexByRegistration(@PathVariable Long registration) {
		return this.repository.findByRegistration(registration);
	}

	@PutMapping("/competitors/{id}")
	Competitor replaceCompetitor(@RequestBody Competitor newCompetitor, @PathVariable Long id) {
		return this.repository.findById(id)
				.map(competitor -> {
					competitor.setName(newCompetitor.getName());
					competitor.setPerformance(newCompetitor.getPerformance());
					competitor.setRegistration(newCompetitor.getRegistration());
					competitor.setStandard(newCompetitor.getStandard());
					return this.repository.save(competitor);
				}).orElseGet(() -> {
					return null;
				});
	}

	@DeleteMapping("/competitors/{id}")
	boolean deleteCompetitor(@PathVariable Long id) {
		this.repository.deleteById(id);
		return this.repository.findById(id).isEmpty();
	}
}
