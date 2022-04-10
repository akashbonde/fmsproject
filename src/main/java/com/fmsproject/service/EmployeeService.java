package com.fmsproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fmsproject.entity.Employee;

@Service
public interface EmployeeService  {
	
	public Employee addEmployee(Employee employee);

	public List<Employee> viewAllEmployee();
}
