package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	  
     
}
