package com.fmsproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmsproject.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
