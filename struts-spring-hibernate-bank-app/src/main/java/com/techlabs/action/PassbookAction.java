package com.techlabs.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import com.techlabs.model.Transactions;
import com.techlabs.service.BankService;


public class PassbookAction implements Action{
	@Autowired
	BankService service;
	private List<Transactions> transactions;
	
	public String passbook() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		String name=(String)session.getAttribute("Admin");
		transactions=service.getAllTransactions(name);
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

}
