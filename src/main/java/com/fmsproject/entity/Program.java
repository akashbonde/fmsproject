package com.fmsproject.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Program implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int programId;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "trainerId")
	private Trainer trainer;
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private Course course;
	
	@OneToMany(mappedBy = "program")
	private Set<Feedback> feedbacks = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="programParticipant", joinColumns = {@JoinColumn(name="programId")}, inverseJoinColumns = {
			@JoinColumn(name="employeeId")})
	private Set<Employee> employees = new HashSet<>();

	Program(){
		
	}

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

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
