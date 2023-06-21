package com.example.demo.service;
import com.example.demo.model.Employee;
import com.example.demo.model.Member;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    
    // 取得分頁使用者資料
    public Page<Employee> getUsersPageable(int page) {
        Pageable pageable = PageRequest.of(page, 3); // 每頁顯示 5 筆資料
        //return empRepository.findAll(pageable);
        return employeeRepository.findAll(pageable);
    }
    
    // 新增使用者
    public Employee addUser(Employee user) {
        return employeeRepository.save(user);
    }

    // 更新使用者
    public Employee updateUser(Employee user) {
        return employeeRepository.save(user);
    }

    // 刪除使用者
    public void deleteEmployee(Long id) {
    	employeeRepository.deleteById(id);
    }   
    
   
    
    @Override
    public List <Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }
}
