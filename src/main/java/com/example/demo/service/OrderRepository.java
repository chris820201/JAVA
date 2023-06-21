package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Order;


// @Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
