package com.vst.spring.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="warehouseorder")
@Table(name="order_tbl")
public class Order {

	@Id
	@Column(name="order_id", nullable = false)
	private int order_id;
	
	@Column(name="description", nullable = false)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Product> products = new HashSet<Product>(0);
	
	public Order(){}
	
	public Order(int order_id)
	{
		this.order_id = order_id;
	}
	
	public Order(int order_id, String description)
	{
		this.order_id = order_id;
		this.description = description;
	}
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
