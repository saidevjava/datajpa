package com.example.transactions.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactions.dto.OrderDTO;
import com.example.transactions.entity.Order;
import com.example.transactions.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private IOrderService orderService;
	
	
	public OrderController(IOrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Order>> fetchAllOrders(){
		List<Order> fetchOrders = orderService.fetchOrders();
		return ResponseEntity.ok(fetchOrders);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> placeOrder(OrderDTO orderDTO){
		orderService.createOrder(orderDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Order Placed Successfully");
	}
}
