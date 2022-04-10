package com.fmsproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Course {

	@Id
	private int courseId;
	
	private String courseName;
	
	private String courseDesc;
	
	private int noOfDays;

	public Course() {
		super();
	}
	
	
}
