package com.fmsproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.TrainerRepository;
import com.fmsproject.entity.Trainer;

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
		
		trainerRepository.deleteById(trainerId);

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
			System.out.println("No trainers Found for this Skillset!");
		}
		
		return trainers;
	}
	
	@Override
	public List<Trainer> viewAllTrainers(String skill) {
		// TODO Auto-generated method stub
		
		List<Trainer> trainers = trainerRepository.getAllTrainersBySkill(skill);
		
		if (trainers.isEmpty()) {
			System.out.println("No trainers Found for this Skillset!");
		}
		
		return trainers;
	}
	
	@Override
	public Trainer viewTrainer(int trainerId) {
		// TODO Auto-generated method stub
		Optional<Trainer> trainer = trainerRepository.findById(trainerId);
		
		if (trainer.isEmpty()) {
			System.out.println("No trainer Found for this Id!");
		}
		
		return trainer.get();
	}
}
