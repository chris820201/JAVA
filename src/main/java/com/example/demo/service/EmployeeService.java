package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Employee;
import com.example.demo.model.Member;

public interface EmployeeService {
	
	//@Query("FROM Employee WHERE position=3")
	//@Query("FROM Employee")
    List <Employee> getAllEmployees();
    
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    
    public Page<Employee> getUsersPageable(int page);
}
