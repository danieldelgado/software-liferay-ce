package com.vst.spring.service;

import java.util.List;

import com.vst.spring.jpa.Order;

public interface OrderService {

	
	public List<Order> getOrders();
	
	public void insertOrder(Order order);
	
	public void deleteOrder(int orderId);
	
}
