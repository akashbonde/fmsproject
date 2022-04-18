package com.fmsproject.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.FeedbackRepository;
import com.fmsproject.entity.Feedback;
import com.fmsproject.exception.NullValueFoundException;

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
			throw new NullValueFoundException("No Feedback Found!");
		}
		
		return allFeedbacks;
	}
	
	@Override
	public Set<Feedback> viewProgramFeedback(int programId) {
		// TODO Auto-generated method stub
		
		Set<Feedback> feedbacks = feedbackRepository.getFeedbacksByProgramId(programId);
		
		if(feedbacks.isEmpty()) {
			throw new NullValueFoundException("No feedback found for the given Program ID");
		}
		
		return feedbacks;
	}

}
