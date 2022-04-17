package com.fmsproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.TrainerRepository;
import com.fmsproject.entity.Trainer;
import com.fmsproject.exception.NullValueFoundException;

@Service("trainerManagementService")
public class TrainerManagementServiceImpl implements TrainerManagementService{
 
	@Autowired
	TrainerRepository trainerRepository;
	
	@Override
	public Trainer addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
		trainerRepository.save(trainer);
		return trainer;
	}
	
	@Override
	public Trainer removeTrainer(int trainerId) {
		// TODO Auto-generated method stub
		
		try {
			trainerRepository.deleteById(trainerId);
		}
		catch(Exception e) {
			throw new NullValueFoundException("No trainer found with the given ID");
		}

		return null;
	}
	
	@Override
	public Trainer updateTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
		trainerRepository.saveAndFlush(trainer);
		return trainer;
	}
	
	@Override
	public List<Trainer> viewAllTrainers() {
		// TODO Auto-generated method stub
		
		List<Trainer> trainers = trainerRepository.findAll();
		
		if (trainers.isEmpty()) {
			throw new NullValueFoundException("No trainers found in the database!!");
		}
		
		return trainers;
	}
	
	@Override
	public List<Trainer> viewAllTrainers(String skill) {
		// TODO Auto-generated method stub
		
		List<Trainer> trainers = trainerRepository.getAllTrainersBySkill(skill);
		
		if (trainers.isEmpty()) {
			throw new NullValueFoundException("No trainers found for this Skillset!");
		}
		
		return trainers;
	}
	
	@Override
	public Trainer viewTrainer(int trainerId) {
		// TODO Auto-generated method stub
		Optional<Trainer> trainer = trainerRepository.findById(trainerId);
		
		if (trainer.isEmpty()) {
			throw new NullValueFoundException("No trainer found for this Id!");
		}
		
		return trainer.get();
	}
}
