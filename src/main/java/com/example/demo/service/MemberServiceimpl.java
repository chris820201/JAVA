package com.example.demo.service;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;

@Service
public class MemberServiceimpl implements MemberService {
	
	@Autowired
    private MemberRepository MemberRepository;

	@Override
	public List<Member> getAllMembers() {
		return MemberRepository.findAll();
	}

	@Override
	public void saveMember(Member member) {
		this.MemberRepository.save(member);
		
	}

	@Override
	public Member getMemberById(Long id) {
		Optional<Member> optional = MemberRepository.findById(id);
        Member member = null;
        if (optional.isPresent()) {
            member = optional.get();
        } else {
            throw new RuntimeException(" Member not found for id :: " + id);
        }
        return member;
	}

	@Override
	public void deleteMemberById(Long id) {
		this.MemberRepository.deleteById(id);
		
	}
    
	// 取得分頁使用者資料
    public Page<Member> getUsersPageable(int page) {
        Pageable pageable = PageRequest.of(page, 5); // 每頁顯示 5 筆資料
        return MemberRepository.findAll(pageable);
    }

	

	
}

	
	
	

