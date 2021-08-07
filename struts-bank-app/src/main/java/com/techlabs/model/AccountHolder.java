package com.techlabs.model;

public class AccountHolder {
	private String name;
	private int balance;
	private String password;
	
	public AccountHolder(String name,int balance,String password) {
		this.setName(name);
		this.setBalance(balance);
		this.setPassword(password);
	}
	public AccountHolder() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
