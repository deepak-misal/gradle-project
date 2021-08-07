package com.techlabs.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.AccountHolder;
import com.techlabs.model.Transaction;
import com.techlabs.service.BankService;

public class RegisterAction implements Action{
	BankService service=new BankService();
	private AccountHolder accountHolder;
	private Transaction transaction;
	private String name;
	private String pass;
	private int balance;
	
	public String add() throws SQLException {
		name=accountHolder.getName();
		pass=accountHolder.getPassword();
		balance=accountHolder.getBalance();
		
		service.addAccounttoDb(accountHolder);
		
		(this.transaction=new Transaction()).setName(name);
		this.transaction.setAmount(balance);
		this.transaction.setType("D");
		
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
		this.accountHolder=accountHolder;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction=transaction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
