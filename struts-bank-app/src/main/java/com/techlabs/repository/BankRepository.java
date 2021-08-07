package com.techlabs.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.techlabs.model.AccountHolder;
import com.techlabs.model.Transaction;

public class BankRepository {
	private Connection con;
	public BankRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banks?" +
					 "user=root&password=root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addAccount(AccountHolder acc) throws SQLException {
		String sql="INSERT INTO BANK_MASTER(NAME,BALANCE,PASSWORD) VALUES(?,?,PASSWORD(?))";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		statement.setString(1, acc.getName());
		statement.setInt(2, acc.getBalance());
		statement.setString(3, acc.getPassword());
		int result=statement.executeUpdate();
		if(result>0) {
			System.out.println("Row Inserted");
		}
	}
	public void addTransaction(Transaction transaction) throws SQLException {
		String sql="INSERT INTO BANK_TRANSACTION(NAME,AMOUNT,TYPE,DATE) VALUES(?,?,?,CURRENT_TIMESTAMP)";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		statement.setString(1, transaction.getName());
		statement.setInt(2, transaction.getAmount());
		statement.setString(3, transaction.getType());
		int result=statement.executeUpdate();
		if(result>0) {
			System.out.println("Transaction Row Inserted");
		}
	}
	public void updateDepositeDB(Transaction transaction) throws SQLException {
		String sql="UPDATE BANK_MASTER SET BALANCE=BALANCE+? WHERE NAME=?";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		statement.setInt(1, transaction.getAmount());
		statement.setString(2, transaction.getName());
		int result=statement.executeUpdate();
		if(result>0) {
			System.out.println("Updated");
		}
	}
	public void updateWithdrawDB(Transaction transaction) throws SQLException {
		String sql="UPDATE BANK_MASTER SET BALANCE=BALANCE-? WHERE NAME=?";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		statement.setInt(1, transaction.getAmount());
		statement.setString(2, transaction.getName());
		int result=statement.executeUpdate();
		if(result>0) {
			System.out.println("Updated");
		}
	}
	public List<Transaction> getList(String name) throws SQLException {
		List<Transaction> transactionList=new ArrayList<Transaction>();
		String sql="SELECT NAME,AMOUNT,TYPE FROM BANK_TRANSACTION WHERE NAME=?";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		statement.setString(1, name);
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			Transaction transaction=new Transaction(rs.getString("NAME"),rs.getInt("AMOUNT"),rs.getString("TYPE"));
			transactionList.add(transaction);
		}
		return transactionList;
	}
	public int getBalance(String name) throws SQLException {
		int bal=0;
		String sql="SELECT BALANCE FROM BANK_MASTER WHERE NAME=?";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		statement.setString(1, name);
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			bal=rs.getInt("BALANCE");
		}
		return bal;
	}
	
}
