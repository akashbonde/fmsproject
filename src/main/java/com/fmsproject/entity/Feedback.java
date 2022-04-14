package com.fmsproject.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Feedback implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	
	private int feedbackCriteria1;
	
	private int feedbackCriteria2;
	
	private int feedbackCriteria3;
	
	private int feedbackCriteria4;
	
	private int feedbackCriteria5;
	
	private String comments;
	
	private String suggestions;
	
	@ManyToOne
	@JoinColumn(name="programId")
	private Program program;
	
	Feedback(){
		
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getFeedbackCriteria1() {
		return feedbackCriteria1;
	}

	public void setFeedbackCriteria1(int feedbackCriteria1) {
		this.feedbackCriteria1 = feedbackCriteria1;
	}

	public int getFeedbackCriteria2() {
		return feedbackCriteria2;
	}

	public void setFeedbackCriteria2(int feedbackCriteria2) {
		this.feedbackCriteria2 = feedbackCriteria2;
	}

	public int getFeedbackCriteria3() {
		return feedbackCriteria3;
	}

	public void setFeedbackCriteria3(int feedbackCriteria3) {
		this.feedbackCriteria3 = feedbackCriteria3;
	}

	public int getFeedbackCriteria4() {
		return feedbackCriteria4;
	}

	public void setFeedbackCriteria4(int feedbackCriteria4) {
		this.feedbackCriteria4 = feedbackCriteria4;
	}

	public int getFeedbackCriteria5() {
		return feedbackCriteria5;
	}

	public void setFeedbackCriteria5(int feedbackCriteria5) {
		this.feedbackCriteria5 = feedbackCriteria5;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	
	
}
