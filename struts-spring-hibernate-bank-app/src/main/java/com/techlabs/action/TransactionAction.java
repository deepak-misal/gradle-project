package com.techlabs.action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.service.BankService;
import com.techlabs.model.AccountHolder;
import com.techlabs.model.Transactions;

public class TransactionAction implements Action{
	@Autowired
	BankService service;
	private Transactions transaction;
	private AccountHolder accountHolder;
	
	public String transaction() {
		int amount=transaction.getAmount();
		String type=transaction.getType();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String name=(String)session.getAttribute("Admin");
		this.accountHolder=service.getAccountHolder(name);
		System.out.println("From Transaction:"+this.accountHolder.getName());
		if(type.equals("D")) {
			(this.transaction=new Transactions()).setAmount(amount);
			this.transaction.setType("D");
			this.transaction.setAccountHolder(this.accountHolder);
			
			Set<Transactions> transset=new HashSet<Transactions>();
			
			transset.add(this.transaction);
			this.accountHolder.setTransacions(transset);
			
			service.addTransactionToDb(this.transaction);
			service.updateDeposite(this.transaction);
		}else {
			(this.transaction=new Transactions()).setAmount(amount);
			this.transaction.setType("W");
			this.transaction.setAccountHolder(this.accountHolder);
			Set<Transactions> transset=new HashSet<Transactions>();
			transset.add(this.transaction);
			this.accountHolder.setTransacions(transset);
			service.addTransactionToDb(this.transaction);
			service.updateWithdraw(this.transaction);
		}
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public Transactions getTransaction() {
		return transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

}
