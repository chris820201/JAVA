package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.example.demo.model.Store;

public interface StoreService {
	List <Store> getAllStores();
    void saveStore(Store Store);
    Store getStoreById(Long id);
    void deleteStoreById(Long id);
    public Page<Store> getStoresPageable(int page);
}
