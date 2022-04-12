package com.fmsproject.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmsproject.entity.Feedback;
import com.fmsproject.service.FeedbackService;

@RestController
@RequestMapping("/api")
public class FeedbackController {

	
	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/feedback")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback) {
		Feedback resultFeedback = feedbackService.addFeedback(feedback);
		
		if (resultFeedback.equals(null)) {
			return new ResponseEntity("Sorry!Feedback not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
	}

	@GetMapping("/programFeedback")
	public ResponseEntity<List<Feedback>> getAllFeedback() {

		List<Feedback> feedbacks = feedbackService.viewAllFeedback();
		
		if (feedbacks.isEmpty()) {
			return new ResponseEntity("Sorry! No feedbacks found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Feedback>>(feedbacks, HttpStatus.OK);
	}

	@GetMapping("/programFeedback/{programId}")
	public ResponseEntity<Set<Feedback>> viewProgramFeedback(@PathVariable("programId") int programId) {

		Set<Feedback> feedbacks = feedbackService.viewProgramFeedback(programId);
		
		if (feedbacks.isEmpty()) {
			return new ResponseEntity("Sorry! No feedbacks found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Set<Feedback>>(feedbacks, HttpStatus.OK);
	}
}
