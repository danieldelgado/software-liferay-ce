package com.vst.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.spring.dao.OrderDao;
import com.vst.spring.dao.OrderDaoImpl;
import com.vst.spring.jpa.Order;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

	private static Log log = LogFactoryUtil.getLog(OrderServiceImpl.class);

//	@BeanReference(name = "com.vst.spring.dao.OrderDaoImpl")
//	@Autowired
//	@Qualifier("OrderDao")
	private OrderDao orderDao = new OrderDaoImpl();
	
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
