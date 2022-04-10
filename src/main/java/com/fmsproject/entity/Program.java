package com.fmsproject.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Program {

	@Id
	private int programId;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "trainerId")
	private Trainer trainer;
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private Course course;

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
