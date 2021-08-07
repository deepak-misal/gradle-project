package com.techlabs.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.techlabs.service.BankService;
import com.techlabs.service.IBankService;
import com.techlabs.model.Transaction;

public class TransactionAction implements Action{
	private Transaction transaction;
	
	public String transaction() {
		int amount=transaction.getAmount();
		String type=transaction.getType();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String name=(String)session.getAttribute("Admin");
		IBankService service=new BankService();
		if(type.equals("D")) {
			service.addTransactcion(new Transaction(name,amount,type));
			service.updateDeposite(new Transaction(name,amount,type));
		}else {
			service.addTransactcion(new Transaction(name,amount,type));
			service.updateWithdraw(new Transaction(name,amount,type));
		}
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
