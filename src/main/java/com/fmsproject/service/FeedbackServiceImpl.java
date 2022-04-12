package com.fmsproject.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.FeedbackRepository;
import com.fmsproject.entity.Feedback;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService{
	
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		feedbackRepository.save(feedback);
		return feedback;
	}
	
	@Override
	public List<Feedback> viewAllFeedback() {
		// TODO Auto-generated method stub
		List<Feedback> allFeedbacks = feedbackRepository.findAll();

		if (allFeedbacks.isEmpty()) {
			System.out.println("No Feedback Found!");
		}
		
		return allFeedbacks;
	}
	
	@Override
	public Set<Feedback> viewProgramFeedback(int programId) {
		// TODO Auto-generated method stub
		return null;
	}

}
