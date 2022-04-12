package com.fmsproject.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fmsproject.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
	
	@Query(value = "SELECT a FROM Program a where a.trainer.trainerId = :trainerIdVariable")
	List<Program> getProgramsById(@Param("trainerIdVariable") int trainerIdVariable);
	
	@Query(value = "SELECT a FROM Program a where a.startDate = :date")
	List<Program> getProgramsByDate(@Param("date") LocalDate date);
}
