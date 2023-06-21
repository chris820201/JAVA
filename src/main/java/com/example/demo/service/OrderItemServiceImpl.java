package com.example.demo.service;

import com.example.demo.model.OrderItem;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderitemRepository;

    @Override
    public List <OrderItem> getAllOrderItem() {
        return orderitemRepository.findAll();
    }

	@Override
	public OrderItem getOrderItemByid(int id) {
		Optional<OrderItem> optional = orderitemRepository.findById(id);
        OrderItem orderitem = null;
        if (optional.isPresent()) {
            orderitem = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return orderitem;
	}
	
	
	//查詢某筆訂單
	@Override
	public List<OrderItem> getOrderItemByorderHeadId(int id) {
		
        return orderitemRepository.findByorderHeadId(id);
	}

	//儲存	
	@Override
	public void saveOrderItme(OrderItem orderitem) {
		orderitemRepository.save(orderitem);
		
	}

	
	

	

	
	
}
