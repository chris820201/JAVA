package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService MemberService;


    @GetMapping("/member")
    public String viewHomePage(Model model,@RequestParam(defaultValue = "0") int page) {
    	Page<Member> empPage = MemberService.getUsersPageable(page);
        model.addAttribute("emps", empPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", empPage.getTotalPages());

        return "member";
    }
    @GetMapping("/showMember")
    public String showNewMemberForm(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "new_member";
    }
    @GetMapping("/show1Member")
    public String showNewMember1Form(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "fnew_member";
    }
    @PostMapping("/saveMember")
    public String saveMember(@ModelAttribute("member") Member member) {
        MemberService.saveMember(member);
        return "redirect:/member";
    }
    @PostMapping("/saveMember1")
    public String saveMember1(@ModelAttribute("member") Member member) {
        MemberService.saveMember(member);
        return "redirect:/";  
    }
    @GetMapping("/login")
    public String loginForm1(Model model) {
        model.addAttribute("member", new Member());
        return "login";
    }
    @GetMapping("/showMemberUpdate/{id}")
    public String showMemberUpdate(@PathVariable(value = "id") Long id, Model model) {
        Member member = MemberService.getMemberById(id);
        model.addAttribute("member", member);
        return "update_member";
    }
    @GetMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable(value = "id") Long id) {
        this.MemberService.deleteMemberById(id);
        return "redirect:/member";
    }
   
 }
