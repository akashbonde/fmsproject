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
		
		Trainer trainerResponse = trainerManagementService.addTrainer(trainer);
		return new ResponseEntity<Trainer>(trainerResponse, HttpStatus.OK);
	}

	
	@PutMapping("/trainer")
	public ResponseEntity<Trainer> updateTrainer(@Valid @RequestBody Trainer trainer) {
		
		Trainer trainerResponse = trainerManagementService.updateTrainer(trainer);

		return new ResponseEntity<Trainer>(trainerResponse, HttpStatus.OK);
	}

	@DeleteMapping("/trainer/{trainerId}")
	public ResponseEntity<Trainer> deleteTrainer(@Valid @PathVariable("trainerId") Integer trainerId) {
		
		trainerManagementService.removeTrainer(trainerId);
		return new ResponseEntity("The trainer is deleted!! ", HttpStatus.ACCEPTED);
	}

	@GetMapping("/trainer/{trainerId}")
	public ResponseEntity<Trainer> findTrainer(@Valid @PathVariable("trainerId") Integer trainerId) {

		Trainer trainer = trainerManagementService.viewTrainer(trainerId);

		return new ResponseEntity<Trainer>(trainer, HttpStatus.OK);
	}

	@GetMapping("trainers/{skill}")
	public ResponseEntity<List<Trainer>> findTrainerBySkill(@Valid @PathVariable("skill") String skill) {

		List<Trainer> trainers = trainerManagementService.viewAllTrainers(skill);

		return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
	}

	@GetMapping("/trainers")
	public ResponseEntity<List<Trainer>> getAllTrainers() {

		List<Trainer> trainers = trainerManagementService.viewAllTrainers();
		
		return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
	}
}
