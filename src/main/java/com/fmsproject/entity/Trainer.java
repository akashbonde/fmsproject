package com.fmsproject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Trainer {

	@Id
	int trainerId;
	
	String trainerName;
	
	String skill;
	
	@OneToMany(mappedBy = "trainer")
	private Set<Program> programs = new HashSet<>();
	
	Trainer(){
		
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Set<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}
	
}
