package com.example.transactions.service;

import java.util.List;

import com.example.transactions.entity.Product;

public interface IProductService {
	
	public void createProduct(Product product);
	public List<Product> fetchProductList();
	
	public boolean updateProduct(String productId, int stock);
	
	 public void manuallyManageTransaction();
	
}
