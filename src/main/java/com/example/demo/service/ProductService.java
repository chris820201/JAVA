package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Order;
import com.example.demo.model.Product;


public interface ProductService {
    List <Product> getAllProduct();
    Product getProductById(int id);
    
    
    //WD
    void saveProduct(Product product);
    void deleteProductById(int id);
    }
