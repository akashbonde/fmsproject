package com.fmsproject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fmsproject.entity.Employee;
import com.fmsproject.entity.Program;

@Service
public interface ProgramManagementService {
	
	public Program createProgram(Program p);

	public Program updateProgram(Program p);

	public List<Program> removeProgram(Integer programId);

	public Program viewProgram(int programId);

	public List<Program> viewAllPrograms();

	public List<Program> viewAllProgramsByDate(LocalDate startdate);

	public List<Program> viewAllProgramsByFaculty(int trainerId);

	public Set<Employee> viewParticipantList(int courseId);

}
