package com.fmsproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmsproject.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{
	
}
