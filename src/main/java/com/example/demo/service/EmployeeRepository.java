package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

// @Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	//@Query("FROM employee WHERE reportTo=1056")
	
}
