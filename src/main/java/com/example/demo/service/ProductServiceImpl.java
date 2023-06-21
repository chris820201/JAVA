package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Order;
import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
   

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	
	@Override
	public Product getProductById(int id) {	
		Optional<Product> optional =  productRepository.findById(id);
		Product product =null;
		if (optional.isPresent()) {
			product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id : " + id);
        }
		return product;
	}
	
	
   //WD
	@Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }
	@Override
    public void deleteProductById(int id) {
        this.productRepository.deleteById(id);
    }
  
}
