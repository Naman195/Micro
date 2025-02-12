package com.ics.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics.security.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	

}
