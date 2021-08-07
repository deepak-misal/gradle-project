package com.techlabs.action;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.AccountHolder;
import com.techlabs.model.Transactions;
import com.techlabs.model.Transactions;
import com.techlabs.service.BankService;

public class RegisterAction implements Action{
	@Autowired
	private BankService service;
	private AccountHolder accountHolder;
	private Transactions transaction;
	private String name;
	private String pass;
	private int balance;
	
	public String add() {
		name=accountHolder.getName();
		pass=accountHolder.getPassword();
		balance=accountHolder.getBalance();
		System.out.println(accountHolder.getName());
		
		service.addAccoutTodb(accountHolder);
		
		(this.transaction=new Transactions()).setAmount(balance);;
		this.transaction.setType("D");
		
		this.transaction.setAccountHolder(accountHolder);
		Set<Transactions> transset=new HashSet<Transactions>();
		transset.add(this.transaction);
		
		accountHolder.setTransacions(transset);
		
		service.addTransactionToDb(transaction);
		return this.SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

}
