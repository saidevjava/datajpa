package com.example.transactions.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactions.entity.Product;
import com.example.transactions.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private IProductService productService;

	public ProductController(IProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> fetchAllProducts(){
		List<Product> fetchProductList = productService.fetchProductList();
		return ResponseEntity.ok(fetchProductList);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createProduct(Product product){
		product.setProductId(UUID.randomUUID().toString());
		productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
	}
	
	@PostMapping("/create_transaction")
	public ResponseEntity<String> createProductTransaction(){
		productService.manuallyManageTransaction();
		return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
	}
	
}
