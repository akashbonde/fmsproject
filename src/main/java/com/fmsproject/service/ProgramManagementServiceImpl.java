package com.fmsproject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.ProgramRepository;
import com.fmsproject.entity.Employee;
import com.fmsproject.entity.Program;

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
	public List<Program> removeProgram(Integer programId) {
		// TODO Auto-generated method stub
		
		programRepository.deleteById(programId);
		
		return programRepository.findAll();
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
			System.out.print("No program found");
		}
		
		return allPrograms;
	}
	
	@Override
	public List<Program> viewAllProgramsByDate(LocalDate startdate) {
		// TODO Auto-generated method stub
		List<Program> resultList = programRepository.getProgramsByDate(startdate);
		return resultList;
	}
	
	@Override
	public List<Program> viewAllProgramsByFaculty(int trainerId) {
		// TODO Auto-generated method stub
		List<Program> resultList = programRepository.getProgramsById(trainerId);
		return resultList;
	}
	
	@Override
	public Set<Employee> viewParticipantList(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Program viewProgram(int programId) {
		// TODO Auto-generated method stub
		return programRepository.findById(programId).get();
	}
}
