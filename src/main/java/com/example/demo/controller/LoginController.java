package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.service.*;
import com.example.demo.model.*;
@Controller
public class LoginController {
    @Autowired
    private LoginService LoginService;

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("member", new Member());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Member member, Model model) {
        if (LoginService.authenticate(member.getUname(), member.getUpsd())) {
            return "redirect:/loginSuccess";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }

   
}