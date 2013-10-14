package it.techannotation.warehouse.service;

import java.util.List;

import it.techannotation.warehouse.dao.OrderDao;
import it.techannotation.warehouse.jpa.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {

	@Autowired
//	@Qualifier("OrderDao")
	private OrderDao orderDao;
	
	public List<Order> getOrders() {		
		return orderDao.getOrders();
	}
	
	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
	}
	
	public void deleteOrder(int orderId) {
		orderDao.deleteOrder(orderId);
	}
	
}
