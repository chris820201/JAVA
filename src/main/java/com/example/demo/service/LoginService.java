package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;

@Service
public class LoginService {
    @Autowired
    private LoginRepository LoginRepository;

    public boolean authenticate(String uname, String upsd) {
        Member member = LoginRepository.findByUname(uname);
        if (member != null && member.getUpsd().equals(upsd)) {
            return true;
        } else {
            return false;
        }
    }
}
