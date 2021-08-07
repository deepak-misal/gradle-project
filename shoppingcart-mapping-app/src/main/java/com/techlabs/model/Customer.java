package com.techlabs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private int cid;
	private String cname;
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
	private Set<Orders> orders;
	public int getCid() {
		return cid;
	}
	public Customer(int cid,String cname) {
		this.cid=cid;
		this.cname=cname;
	}
	public Customer() {
		
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return cname;
	}
	public void setName(String name) {
		this.cname = name;
	}
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

}
