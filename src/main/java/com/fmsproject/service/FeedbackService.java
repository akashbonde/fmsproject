package com.fmsproject.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fmsproject.entity.Feedback;

@Service
public interface FeedbackService {
	
	public Feedback addFeedback(Feedback feedback);

	public Set<Feedback> viewProgramFeedback(int programId);

	public List<Feedback> viewAllFeedback();

}
