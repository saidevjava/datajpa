package com.example.transactions.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactions.dto.OrderDTO;
import com.example.transactions.entity.Order;
import com.example.transactions.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	private OrderRepository orderRepository;

	private IProductService productService;

	public OrderServiceImpl(OrderRepository orderRepository, IProductService productService) {
		super();
		this.orderRepository = orderRepository;
		this.productService = productService;
	}

	@Override
	//@Transactional(value = TxType.REQUIRED)
	@Transactional(isolation = Isolation.READ_UNCOMMITTED,propagation = Propagation.MANDATORY)
	public void createOrder(OrderDTO orderDto) {

		Order order = new Order();
		order.setCustomerName(orderDto.getCustomerName());
		order.setMobileNumber(orderDto.getMobileNumber());
		order.setOrderId(UUID.randomUUID().toString());
		orderRepository.save(order);
		productService.updateProduct(orderDto.getProductId(), orderDto.getCount());
	}

	@Override
	public List<Order> fetchOrders() {
		return orderRepository.findAll();
	}

}
