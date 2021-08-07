package com.techlab.services;

import java.util.List;

import com.techlab.model.AccountHolder;
import com.techlab.model.Transaction;

public interface IBankService {
	public void addAccount(AccountHolder acc);
	public void addTransactcion(Transaction transaction);
	public void updateDeposite(Transaction transaction);
	public void updateWithdraw(Transaction transaction);
	public List<Transaction> getListByName(String name);
}
