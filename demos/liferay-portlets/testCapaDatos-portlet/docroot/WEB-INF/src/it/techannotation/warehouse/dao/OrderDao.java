package it.techannotation.warehouse.dao;

import it.techannotation.warehouse.jpa.Order;

import java.util.List;

public interface OrderDao {
	public List<Order> getOrders();	
	public void insertOrder(Order order);
	public void deleteOrder(int orderId);
}
