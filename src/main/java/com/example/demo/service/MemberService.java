package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Member;

public interface MemberService {
	List <Member> getAllMembers();
    void saveMember(Member member);
    Member getMemberById(Long id);
    void deleteMemberById(Long id);
    public Page<Member> getUsersPageable(int page);
}
