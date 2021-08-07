package com.techlabs.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	private int pid;
	private String pname;
	private int cost;
	@ManyToOne
	@JoinColumn
	private LineItem item;
	public Product(int pid,String pname,int cost) {
		this.pid=pid;
		this.pname=pname;
		this.cost=cost;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public LineItem getItem() {
		return item;
	}
	public void setItem(LineItem item) {
		this.item = item;
	}
	

}
