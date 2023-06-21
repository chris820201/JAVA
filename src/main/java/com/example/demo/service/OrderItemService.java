package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.OrderItem;


public interface OrderItemService {
    List <OrderItem> getAllOrderItem();
    OrderItem getOrderItemByid(int id);
    List<OrderItem> getOrderItemByorderHeadId(int orderHeadId);
    void saveOrderItme(OrderItem orderitem);
}
