package com.techlabs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id
	private int oid;
	private String odate;
	@ManyToOne
	@JoinColumn
	private Customer customer;
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private Set<LineItem> items;
	public Orders(int oid, String odate) {
		this.oid=oid;
		this.odate=odate;
	}
	public Orders() {
		
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<LineItem> getItems() {
		return items;
	}
	public void setItems(Set<LineItem> items) {
		this.items = items;
	}
}
