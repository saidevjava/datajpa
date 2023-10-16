package com.example.transactions.service;

import java.util.List;

import com.example.transactions.dto.OrderDTO;
import com.example.transactions.entity.Order;

public interface IOrderService {
	
	public void createOrder(OrderDTO orderDto);
	public List<Order> fetchOrders();
}
