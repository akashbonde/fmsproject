package com.fmsproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmsproject.dao.EmployeeRepository;
import com.fmsproject.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeRepository.saveAndFlush(employee);
		
		return employee;
	}
	
	@Override
	public List<Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> allEmployee = employeeRepository.findAll();

		if (allEmployee.isEmpty()) {
			System.out.println("No Employee found!!");
		}

		return allEmployee;
	}

}
