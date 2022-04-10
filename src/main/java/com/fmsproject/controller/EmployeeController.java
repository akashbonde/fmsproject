package com.fmsproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmsproject.entity.Employee;
import com.fmsproject.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		Employee employeeResponse = employeeService.addEmployee(employee);
		
		if (employeeResponse.equals(null)) {
			return new ResponseEntity("Sorry!Employee not inserted!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/employees/all")
	public List<Employee> viewAllEmpoyees() {

		List<Employee> employees = employeeService.viewAllEmployee();
		return employees;
	}
}
