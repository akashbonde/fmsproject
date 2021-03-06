package com.fmsproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fmsproject.entity.Employee;
import com.fmsproject.entity.Program;
import com.fmsproject.service.ProgramManagementService;

@RestController
@RequestMapping("/api")
public class ProgramController {

	@Autowired
	private ProgramManagementService programManagementService;
	
	@PutMapping("/programs")
	public ResponseEntity<Program> updateProgram(@Valid @RequestBody Program program) {
		Program programResponse = programManagementService.updateProgram(program);

		return new ResponseEntity<Program>(programResponse, HttpStatus.OK);
	}

	@PostMapping("/programs")
	public ResponseEntity<Program> addProgram(@Valid @RequestBody Program program) {
		Program programResponse = programManagementService.createProgram(program);
	
		return new ResponseEntity<Program>(program, HttpStatus.OK);
	}

	@GetMapping("/programs/{programId}")
	public ResponseEntity<Program> findProgram(@Valid @PathVariable("programId") Integer programId) {

		Program program = programManagementService.viewProgram(programId);

		return new ResponseEntity<Program>(program, HttpStatus.OK);
	}

	@GetMapping("/programs")
	public List<Program> viewAllProgram() {
		
		return programManagementService.viewAllPrograms();
	}

	@DeleteMapping("/programs/{programId}")
	public ResponseEntity<List<Program>> deleteprogram(@PathVariable("programId") Integer programId) {
		programManagementService.removeProgram(programId);

		return new ResponseEntity("Program deleted!", HttpStatus.OK);
	}

	@GetMapping("/programsByTrainer/{trainerId}")
	public ResponseEntity<List<Program>> viewProgramsById(@PathVariable("trainerId") int trainerId) {

		List<Program> programs = programManagementService.viewAllProgramsByFaculty(trainerId);
		
		return new ResponseEntity<List<Program>>(programs, HttpStatus.OK);
	}

	@GetMapping("/employeesByCourse/{courseId}")
	public ResponseEntity<Set<Employee>> getEmployeeByCourseId(@PathVariable("courseId") int courseId) {

		Set<Employee> empSet = programManagementService.viewParticipantList(courseId);
		
		return new ResponseEntity<Set<Employee>>(empSet, HttpStatus.OK);
	}

	@GetMapping("/programsByDate/")
	List<Program> getAllInactiveUsers(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
				
		return programManagementService.viewAllProgramsByDate(date);
	}
}
