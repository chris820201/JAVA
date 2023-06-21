package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderItem;

// @Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
	List<OrderItem> findByorderHeadId(int orderHeadId);
	
	
}
