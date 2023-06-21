package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface ELoginRepository extends JpaRepository<Employee, Integer> {
    Employee findByAccount(String account);
}