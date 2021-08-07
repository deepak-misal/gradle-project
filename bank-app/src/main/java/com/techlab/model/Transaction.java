package com.techlab.model;

public class Transaction {
	private String name;
	private int amount;
	private String type;
	
	public Transaction(String name,int amount,String type) {
		this.name=name;
		this.amount=amount;
		this.type=type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public int getAmount() {
		return amount;
	}
	
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}
