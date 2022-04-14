package com.fmsproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmsproject.entity.Trainer;
import com.fmsproject.service.TrainerManagementService;

@RestController
@RequestMapping("/api")
public class TrainerController {

	@Autowired
	TrainerManagementService trainerManagementService;
	
	@PostMapping("/trainer")
	public ResponseEntity<Trainer> insertTrainer(@Valid @RequestBody Trainer trainer) {
		
		Trainer trainer1 = trainerManagementService.addTrainer(trainer);

		if (trainer1 == null) {
			return new ResponseEntity("No trainer Available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Trainer>(trainer1, HttpStatus.OK);
	}

	
	@PutMapping("/trainer")
	public ResponseEntity<Trainer> updateTrainer(@Valid @RequestBody Trainer trainer) {
		
		Trainer trainer1 = trainerManagementService.updateTrainer(trainer);

		if (trainer1 == null) {
			return new ResponseEntity("No trainer Available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Trainer>(trainer1, HttpStatus.OK);
	}

	@DeleteMapping("/trainer/{trainerId}")
	public ResponseEntity<Trainer> deleteTrainer(@Valid @PathVariable("trainerId") Integer trainerId) {
		
		Trainer trainer1 = trainerManagementService.removeTrainer(trainerId);

		if (trainer1 == null) {
			return new ResponseEntity("Successfully deleted trainer", HttpStatus.OK);
		}
		return new ResponseEntity<Trainer>(trainer1, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/trainer/{trainerId}")
	public ResponseEntity<Trainer> findTrainer(@Valid @PathVariable("trainerId") Integer trainerId) {

		Trainer trainer1 = trainerManagementService.viewTrainer(trainerId);
		if (trainer1 == null) {
			return new ResponseEntity("Sorry! No trainer found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Trainer>(trainer1, HttpStatus.OK);
	}

	@GetMapping("trainers/{skill}")
	public ResponseEntity<List<Trainer>> findTrainerBySkill(@Valid @PathVariable("skill") String skill) {

		List<Trainer> trainers = trainerManagementService.viewAllTrainers(skill);

		if (trainers.isEmpty()) {
			return new ResponseEntity("Sorry! No trainer found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
	}

	@GetMapping("/trainers")
	public ResponseEntity<List<Trainer>> getAllTrainers() {

		List<Trainer> trainers = trainerManagementService.viewAllTrainers();
		if (trainers.isEmpty()) {
			return new ResponseEntity("Sorry! No trainers are available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
	}
}
