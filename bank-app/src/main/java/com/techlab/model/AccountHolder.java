package com.techlab.model;

public class AccountHolder {
	private String name;
	private int balance;
	private String password;
	
	public AccountHolder(String name,int balance,String password) {
		this.name=name;
		this.balance=balance;
		this.password=password;
	}
	public AccountHolder() {
		
	}
	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public String getPassword() {
		return password;
	}
}
