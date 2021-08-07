package com.techlabs.model;



import java.sql.Timestamp;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {
	@Id
	private String id=UUID.randomUUID().toString();
	private int amount;
	private String type;
	private Timestamp dateTime=new Timestamp(new java.util.Date().getTime());
	@ManyToOne
	@JoinColumn
	private AccountHolder accountHolder;
	
	public Transactions(int amount,String type) {
		
		this.setAmount(amount);
		this.setType(type);
	}
	public Transactions() {
		
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
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp sqlTime) {
		this.dateTime = sqlTime;
	}
}
