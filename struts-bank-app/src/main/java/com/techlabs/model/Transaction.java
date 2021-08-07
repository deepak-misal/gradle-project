package com.techlabs.model;

public class Transaction {
	private String name;
	private int amount;
	private String type;
	
	public Transaction(String name,int amount,String type) {
		this.setName(name);
		this.setAmount(amount);
		this.setType(type);
	}
	public Transaction() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
