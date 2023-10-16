package com.example.transactions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactions.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public Optional<Product> findByProductId(String uuid);
}
