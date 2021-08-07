package com.techlabs.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.repository.BankRepository;

public class HomeAction implements Action{
	@Autowired
	BankRepository repo;
	private int accountBalance;
	private String name;

	@Override
	public String execute() throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		name=(String) session.getAttribute("Admin");
		System.out.println(name);
		if(name!=null) {
			accountBalance=repo.getBalance(name);
		}
		
		
		return this.SUCCESS;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
