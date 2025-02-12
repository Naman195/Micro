package com.ics.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ics.security.entity.Product;
import com.ics.security.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProduct() {
		return repository.findAll();
	}
	
	public Product getProductById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
