package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCart;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderItemService orderitemService;
    private ShoppingCart shoppingCart = new ShoppingCart();
    //取得全部
    @GetMapping("/product")
    public String getAll(Model model) {
        model.addAttribute("listproduct", productService.getAllProduct());
        return "product";
    }
    
    //cart
    @GetMapping("/cart")
    public String index(Model model) {
        model.addAttribute("products", shoppingCart.getProduct());
        model.addAttribute("total", shoppingCart.getTotal());
        return "cart";
    }   
    //add cart
    @GetMapping("/add/{id}")   
    public String addcart(@PathVariable(value = "id") int id, Model model) {
    	if(shoppingCart.getSize() == 0)
    	{
    		Product product = productService.getProductById(id);//取得選擇的商品
    		Product product2 =new Product();
    		product2.setpId(product.getpId());
           	product2.setfId(1);
           	product2.setpName(product.getpName());
           	product2.setPrice(product.getPrice());
           	shoppingCart.addProduct(product2);//加入購物車 
    	}
    	else
    	{
    		Product product = productService.getProductById(id);//取得選擇的商品
    		Product product2 =new Product();
    		product2.setpId(product.getpId());
           	product2.setfId(shoppingCart.getSize()+1);    		
           	product2.setpName(product.getpName());
           	product2.setPrice(product.getPrice());
           	shoppingCart.addProduct(product2);//加入購物車 
    	}
        return "redirect:/product";
    }
    
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable(value = "id") int id) {
    	Product product =new Product();
    	product.setfId(id);
    	Product productToDelete = null;
    	for (Product p : shoppingCart.getProduct()) {
    	    if (p.getfId() == product.getfId()) {
    	        productToDelete = p;
    	        break;
    	    }
    	}
    	shoppingCart.removeProduct(productToDelete);
        return "redirect:/cart";
    }
 
    //WD
 // display list of product
    @GetMapping("/wdproduct")
    public String viewHomePage(Model model) {
        model.addAttribute("listProduct", productService.getAllProduct());
        return "wdproduct";
    }
    
    @GetMapping("/showForm99")
    public String showNewProductForm(Model model) {
        // create model attribute to bind form data
    	Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        // save product to database
    	productService.saveProduct(product);
        return "redirect:/wdproduct";
    }

    @GetMapping("/showForm99ForUpdate/{id}")
    public String showForm99ForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get product from the service
    	Product product = productService.getProductById(id);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id) {

        // call delete product method 
        this.productService.deleteProductById(id);
        return "redirect:/wdproduct";
    }
}
