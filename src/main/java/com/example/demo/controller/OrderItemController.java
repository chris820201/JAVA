package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.service.OrderItemService;

@Controller
public class OrderItemController {

    @Autowired
    private OrderItemService orderitemService;
    

    // display list of employees
    @GetMapping("/orderitem")
    public String viewHomePage(Model model) {
        model.addAttribute("listOrdersItem", orderitemService.getAllOrderItem());
        return "orderitem";
    }
       
    @GetMapping("/showorderitem/{id}")
    public String showOrderItem(@PathVariable(value = "id") int id, Model model) {    	
    	
        List<OrderItem> orderitem = orderitemService.getOrderItemByorderHeadId(id);        
        model.addAttribute("listOrdersItem", orderitem);
        return "orderitem";
    }
    
    
    
    
   
 
    
  
}
