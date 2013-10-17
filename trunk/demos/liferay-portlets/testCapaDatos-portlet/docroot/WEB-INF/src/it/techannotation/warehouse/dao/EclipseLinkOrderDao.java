package it.techannotation.warehouse.dao;

import it.techannotation.warehouse.jpa.Order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("OrderDao")
public class EclipseLinkOrderDao implements OrderDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrders() {

		Query query = em.createQuery("SELECT o FROM warehouseorder o",
				Order.class);
		query.setHint("javax.persistence.cache.storeMode", "REFRESH");
		
		List<Order> orders = query.getResultList();

		return orders;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertOrder(Order order) {
		em.persist(order);

	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteOrder(int orderId) {
		Order order = em.find(Order.class, orderId);

		em.remove(order);

	}
}