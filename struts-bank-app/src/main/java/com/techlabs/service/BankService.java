package com.techlabs.service;

import java.sql.SQLException;
import java.util.List;

import com.techlabs.model.AccountHolder;
import com.techlabs.model.Transaction;
import com.techlabs.repository.BankRepository;

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
	public void addAccounttoDb(AccountHolder accountHolder) throws SQLException {
		repo.addAccount(accountHolder);
	}
	public void addTransactionToDb(Transaction transaction) throws SQLException {
		repo.addTransaction(transaction);
	}

}
