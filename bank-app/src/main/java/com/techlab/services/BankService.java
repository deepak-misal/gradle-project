package com.techlab.services;

import java.sql.SQLException;
import java.util.List;

import com.techlab.model.AccountHolder;
import com.techlab.model.Transaction;
import com.techlab.repository.BankRepository;

public class BankService implements IBankService{
	BankRepository repo=new BankRepository();

	@Override
	public void addAccount(AccountHolder acc) {
		try {
			repo.addAccount(acc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addTransactcion(Transaction transaction) {
		try {
			repo.addTransaction(transaction);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateDeposite(Transaction transaction) {
		try {
			repo.updateDepositeDB(transaction);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateWithdraw(Transaction transaction) {
		try {
			repo.updateWithdrawDB(transaction);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Transaction> getListByName(String name) {
		try {
			List<Transaction> transactions=repo.getList(name);
			return transactions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}
