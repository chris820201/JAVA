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
public class ELoginController {
    @Autowired
    private ELoginService ELoginService;

    @GetMapping("/elogin")
    public String loginForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "elogin";
    }

    @PostMapping("/elogin1")
    public String login(@ModelAttribute Employee employee, Model model) {
        if (ELoginService.authenticate(employee.getAccount(), employee.getPassword())) {
            return "redirect:/managerindex";
        } else {
            model.addAttribute("error", "Invalid account or password.");
            return "elogin";
        }
    }

   
}