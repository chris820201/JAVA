package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class ELoginService {
    @Autowired
    private ELoginRepository ELoginRepository;

    public boolean authenticate(String account, String password) {
        Employee employee = ELoginRepository.findByAccount(account);
        if (employee != null && employee.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
