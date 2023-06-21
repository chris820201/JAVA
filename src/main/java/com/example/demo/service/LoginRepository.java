package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Member;

@Repository
public interface LoginRepository extends JpaRepository<Member, Integer> {
    Member findByUname(String uname);
}
