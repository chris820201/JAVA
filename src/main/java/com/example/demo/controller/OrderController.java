package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    //Jim
    @Autowired
    private OrderItemService orderitemService;

    //取得全部
    @GetMapping("/order")
    public String viewHomePage(Model model) {
        model.addAttribute("listOrder", orderService.getAllOrder());
        return "order";
    }
    
    //取得某筆資料
    @GetMapping("/orderbyid/{id}")
    public String orderbyid(@PathVariable(value = "id") int id, Model model) {

        
        Order order = orderService.getOrderById(id);
        model.addAttribute("listOrder", order);
        return "order";
    } 
    
    //儲存資料
    @GetMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") Order order) {
        // save employee to database
    	orderService.saveOrder(order);
        return "redirect:/";
    }
  
   
    
    //Jim 
    @GetMapping("/orderbs")
   public String getOrders(Model model, @RequestParam(defaultValue = "0") int page) {
        
    	Page<Order> ordPage = orderService.getOrderPageable(page);  
        

      	List<Order> ordsTmp = ordPage.getContent();
      	List<Order> ordsGo = new ArrayList<>();
      	
    	for(Order o: ordsTmp)
    	{
      	   if(o.getOrderStatus() == 1)
      	   {
      		 ordsGo.add(o);
      	   }
    	}	
      	
    	//model.addAttribute("ords", ordPage.getContent());
    	model.addAttribute("ords", ordsGo);
        model.addAttribute("currentPage", page);

        //model.addAttribute("currentPage2", JsonString2);
        
        model.addAttribute("totalPages", ordPage.getTotalPages());
        return "ordList"; // 返回 Thymeleaf 模板名稱
    }
    
    //取得某筆資料
    @GetMapping("/orderbs/{id}")
    public String orderbyidnew(@PathVariable(value = "id") int id, Model model) {
   // public String getOrdersItem(@PathVariable(value = "id") int id ,Model model) {
    List<OrderItem> orderitem = orderitemService.getOrderItemByorderHeadId(id);        
	model.addAttribute("listOrdersItem", orderitem);
	//return "orderitem";
	return  "Order_item";
	    
   }
  
   // /* 
    //完成某筆定單
    //@GetMapping("/orderbs/{id}")  // Can be the same
    @GetMapping("/orderupdate/{id}")
    public String getOrderOk(@PathVariable(value = "id") int id,Model model) {
    Order ord = orderService.getOrderById(id);	 
    ord.setOrderStatus(3);  // status = 3 (完成)
    orderService.updateOrd(ord);

	return  "redirect:/orderbs";
	//return  "ordList" ;
   }
    
    
}
