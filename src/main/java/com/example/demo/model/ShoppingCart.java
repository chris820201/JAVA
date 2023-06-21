package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product ) {
    	products.add(product);
    }

    public void removeProduct(Product product) {
    	products.remove(product);
    }

    public List<Product> getProduct() {
        return products;
    } 
    
	public int getTotal() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
	
	public int getSize() {
		int size = 0;
		size = products.size();	
		return size;
	}
    
    
}