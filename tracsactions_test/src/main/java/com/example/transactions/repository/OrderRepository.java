package com.example.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactions.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
