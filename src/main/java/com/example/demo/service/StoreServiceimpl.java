package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.model.Store;

@Service
public class StoreServiceimpl implements StoreService {
    
	@Autowired
    private StoreRepository StoreRepository;
	
	@Override
	public List<Store> getAllStores() {
		return StoreRepository.findAll();
	}

	@Override
	public void saveStore(Store Store) {
		this.StoreRepository.save(Store);
		
	}

	@Override
	public Store getStoreById(Long id) {
		Optional<Store> optional = StoreRepository.findById(id);
        Store Store = null;
        if (optional.isPresent()) {
            Store = optional.get();
        } else {
            throw new RuntimeException(" Store not found for id :: " + id);
        }
        return Store;
	}

	@Override
	public void deleteStoreById(Long id) {
		this.StoreRepository.deleteById(id);
		
	}

	@Override
	public Page<Store> getStoresPageable(int page) {
		 Pageable pageable = PageRequest.of(page, 5); // 每頁顯示 5 筆資料
	        return StoreRepository.findAll(pageable);
	}

}
