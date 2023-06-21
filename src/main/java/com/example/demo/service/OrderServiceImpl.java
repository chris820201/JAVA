package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List <Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = null;
        if (optional.isPresent()) {
        	order = optional.get();
        } else {
            throw new RuntimeException(" Order not found for id :: " + id);
        }
        return order;
    }

	@Override
	public void saveOrder(Order order) {
		this.orderRepository.save(order);
		
	} 
    
    
	@Override
	public Page<Order> getOrderPageable(int page) {
        Pageable pageable = PageRequest.of(page, 4); // 每頁顯示 5 筆資料
        //return empRepository.findAll(pageable);
        
        //orderRepository.s
        return orderRepository.findAll(pageable);
	}

	// /*
	@Override
	public void updateOrd(Order ord) {
		//return 
		orderRepository.save(ord);
	}
	
  
}
