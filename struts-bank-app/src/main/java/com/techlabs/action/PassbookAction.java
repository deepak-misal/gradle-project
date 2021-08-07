package com.techlabs.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Transaction;
import com.techlabs.service.BankService;
import com.techlabs.service.IBankService;

public class PassbookAction implements Action{
	private List<Transaction> transactions;
	
	public String passbook() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		String name=(String)session.getAttribute("Admin");
		IBankService service=new BankService();
		transactions=service.getListByName(name);
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
