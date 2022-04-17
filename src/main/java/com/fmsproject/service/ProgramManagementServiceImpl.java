package com.fmsproject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.ProgramRepository;
import com.fmsproject.entity.Course;
import com.fmsproject.entity.Employee;
import com.fmsproject.entity.Program;
import com.fmsproject.exception.NullValueFoundException;

@Service("programManagementService")
public class ProgramManagementServiceImpl implements ProgramManagementService{

	
	@Autowired
	ProgramRepository programRepository;
	
	@Override
	public Program createProgram(Program program) {
		// TODO Auto-generated method stub
		
		programRepository.saveAndFlush(program);
		return program;
	}
	
	@Override
	public Program removeProgram(Integer programId) {
		// TODO Auto-generated method stub
		
		try {
			programRepository.deleteById(programId);
		}
		catch(Exception e) {
			throw new NullValueFoundException("No program found with the given Id");
		}
		
		return null;
	}
	
	@Override
	public Program updateProgram(Program program) {
		// TODO Auto-generated method stub
		return programRepository.saveAndFlush(program);
	}
	
	@Override
	public List<Program> viewAllPrograms() {
		// TODO Auto-generated method stub

		List<Program> allPrograms = programRepository.findAll();
		
		if(allPrograms.isEmpty()) {
			throw new NullValueFoundException("No programs found in the database");
		}
		
		return allPrograms;
	}
	
	@Override
	public List<Program> viewAllProgramsByDate(LocalDate startdate) {
		// TODO Auto-generated method stub
		List<Program> resultList = programRepository.getProgramsByDate(startdate);
		
		if(resultList.isEmpty()) {
			throw new NullValueFoundException("No program with given start date present in the database!");
			
		}
		
		return resultList;
	}
	
	@Override
	public List<Program> viewAllProgramsByFaculty(int trainerId) {
		// TODO Auto-generated method stub
		List<Program> programs = programRepository.getProgramsById(trainerId);

		if(programs.isEmpty()) {
			throw new NullValueFoundException("No Program for the given trainer present in the database!");
		}
		
		return programs;
	}
	
	@Override
	public Set<Employee> viewParticipantList(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Program viewProgram(int programId) {
		// TODO Auto-generated method stub
		
		Optional<Program> program = programRepository.findById(programId);

		if(!program.isPresent()) {
			throw new NullValueFoundException("No Program with given Id present in the database!");
		}
		
		return program.get();
	}
}
