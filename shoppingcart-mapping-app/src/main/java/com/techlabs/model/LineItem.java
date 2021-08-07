package com.techlabs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class LineItem {
	@Id
	private int lid;
	private int quantity;
	@ManyToOne
	@JoinColumn
	private Orders order;
	@OneToMany(mappedBy="item", cascade = CascadeType.ALL)
	private Set<Product> products;
	public LineItem(int lid,int quantity) {
		this.lid=lid;
		this.quantity=quantity;
	}
	public LineItem() {
		
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
