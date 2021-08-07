package com.techlabs.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.model.AccountHolder;
import com.techlabs.model.Transactions;
import com.techlabs.repository.BankRepository;
@Service
public class BankService{
	@Autowired
	BankRepository repo;
	
	public BankService() {
		System.out.println("Bank Service");
	}
	
	public void addAccoutTodb(AccountHolder acc) {
		repo.addAccount(acc);
	}
	public void addTransactionToDb(Transactions trans) {
		repo.addTransaction(trans);
	}
	public List<Transactions> getAllTransactions(String name){
		return repo.getTransactions(name);
	}
	public void updateDeposite(Transactions trans) {
		repo.updateDeposite(trans);
	}
	public void updateWithdraw(Transactions trans) {
		repo.updateWithdraw(trans);
	}
	public AccountHolder getAccountHolder(String name) {
		return repo.getAccountHolder(name);
	}
}
