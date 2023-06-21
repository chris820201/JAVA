package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.demo.model.Order;


public interface OrderService {
    List <Order> getAllOrder();
    Order getOrderById(int id);
    void saveOrder(Order order);
    
    public Page<Order> getOrderPageable(int page);
    public void updateOrd(Order ord);
   
}
