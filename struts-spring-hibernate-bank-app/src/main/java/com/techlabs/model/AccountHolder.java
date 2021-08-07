package com.techlabs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.techlabs.service.Encryption;

@Entity
public class AccountHolder {
	@Id
	private String name;
	private int balance;
	private String password;
	@OneToMany(mappedBy="accountHolder", cascade = CascadeType.ALL)
	private Set<Transactions> transacions;
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
		this.password = Encryption.encrypt(password);
	}
	public Set<Transactions> getTransacions() {
		return transacions;
	}
	public void setTransacions(Set<Transactions> transacions) {
		this.transacions = transacions;
	}
	
}
