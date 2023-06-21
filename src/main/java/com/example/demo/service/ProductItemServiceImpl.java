package com.example.demo.service;

import com.example.demo.model.ProductItem;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductItemServiceImpl implements ProductItemService {

    @Autowired
    private ProductItemRepository productitemRepository;

    @Override
    public List <ProductItem> getAllProductItem() {
        return productitemRepository.findAll();
    }

    
}
