package com.example.transactions.dto;

import lombok.Data;

@Data
public class OrderDTO {
	
	private String mobileNumber;
	private String customerName;
	private String productId;
	private int count;
}
