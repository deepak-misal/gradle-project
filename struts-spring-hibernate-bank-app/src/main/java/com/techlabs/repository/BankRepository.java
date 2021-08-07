package com.techlabs.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.techlabs.model.AccountHolder;
import com.techlabs.model.Transactions;
@Repository
public class BankRepository {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	public void addAccount(AccountHolder acc) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(acc);
		transaction.commit();
		session.close();
	}
	public void addTransaction(Transactions trans) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(trans);
		transaction.commit();
		session.close();
	}
	public int getBalance(String name) {
		session=sessionFactory.openSession();
		Query query=session.createQuery("select balance from AccountHolder where name=:n");
		query.setParameter("n", name);
		int balance = ((Number)query.uniqueResult()).intValue();
		System.out.println(balance);
		return balance;
	}
	public List<Transactions> getTransactions(String name){
		session=sessionFactory.openSession();
		Query query=session.createQuery("from Transactions where accountHolder_name=:n");
		query.setParameter("n",name);
		List<Transactions> resultRaw = query.list();
		List<Transactions> result = new ArrayList<Transactions>(resultRaw.size());
		for (Object o : resultRaw) {
		    result.add((Transactions) o);
		}
		System.out.println(result);
		return result;
		
	}
	public void updateDeposite(Transactions trans) {
		System.out.println("in update");
		HttpSession session1=ServletActionContext.getRequest().getSession();
		String name=(String)session1.getAttribute("Admin");
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query=session.createQuery("update AccountHolder set balance= balance + :a where name=:n");
		query.setParameter("a", trans.getAmount());
		query.setParameter("n", name);
		int status=query.executeUpdate();
		System.out.println(status);
		transaction.commit();
		
	}
	public void updateWithdraw(Transactions trans) {
		HttpSession session1=ServletActionContext.getRequest().getSession();
		String name=(String)session1.getAttribute("Admin");
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query=session.createQuery("update AccountHolder set balance= balance- :a where name=:n");
		query.setParameter("a", trans.getAmount());
		query.setParameter("n", name);
		int status=query.executeUpdate();
		System.out.println(status);
		transaction.commit();
		
	}
	public AccountHolder getAccountHolder(String name) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query=session.createQuery("from AccountHolder where name=:n");
		query.setParameter("n", name);
		AccountHolder acc=(AccountHolder) query.uniqueResult();
		System.out.println(acc.getName());
		return acc;
	}
	
}
