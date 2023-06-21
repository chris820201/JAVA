package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Product;


// @Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
