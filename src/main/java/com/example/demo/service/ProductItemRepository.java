package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductItem;

// @Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Integer>{

}
