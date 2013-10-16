package com.vst.spring.dao;

import java.util.List;

import com.vst.spring.jpa.Order;

public interface OrderDao {
	public List<Order> getOrders();	
	public void insertOrder(Order order);
	public void deleteOrder(int orderId);
}
