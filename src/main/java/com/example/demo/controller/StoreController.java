package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Member;
import com.example.demo.model.Store;
import com.example.demo.service.StoreService;

@Controller
public class StoreController {
	 @Autowired
	    private StoreService StoreService;


	    @GetMapping("/store")
	    public String viewHomePage(Model model,@RequestParam(defaultValue = "0") int page) {
	    	Page<Store> empPage = StoreService.getStoresPageable(page);
	        model.addAttribute("emps", empPage.getContent());
	        model.addAttribute("currentPage", page);
	        model.addAttribute("totalPages", empPage.getTotalPages());

	        return "store";
	    }
	    @GetMapping("/loginSuccess")
	    public String viewHomePage1(Model model,@RequestParam(defaultValue = "0") int page) {
	    	Page<Store> empPage1 = StoreService.getStoresPageable(page);
	        model.addAttribute("emps1", empPage1.getContent());
	        model.addAttribute("currentPage1", page);
	        model.addAttribute("totalPages1", empPage1.getTotalPages());

	        return "showStores";
	    }
	    
	    @GetMapping("/orderTest")
	    public String orderTest() {
	    	return "orderTest";
	    }
	    @GetMapping("/showStore")
	    public String showNewStoreForm(Model model) {
	        Store store = new Store();
	        model.addAttribute("store", store);
	        return "new_store";
	    }
	    @PostMapping("/saveStore")
	    public String saveStore(@ModelAttribute("store") Store store) {
	        StoreService.saveStore(store);
	        return "redirect:/store";
	    }
	    @GetMapping("/showStoreUpdate/{id}")
	    public String showStoreUpdate(@PathVariable(value = "id") Long id, Model model) {
	        Store store = StoreService.getStoreById(id);
	        model.addAttribute("store", store);
	        return "update_store";
	    }
	    @GetMapping("/deleteStore/{id}")
	    public String deleteStore(@PathVariable(value = "id") Long id) {
	        this.StoreService.deleteStoreById(id);
	        return "redirect:/store";
	    }

}
