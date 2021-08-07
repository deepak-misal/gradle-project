package com.techlabs.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.techlabs.model.AccountHolder;
import com.techlabs.model.LoginBean;
import com.techlabs.service.Encryption;
@Repository
public class LoginRepository {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	public String authenticateUser(LoginBean loginBean) {
		System.out.println("In Auth");
		String username=loginBean.getUsername();
		String password=Encryption.encrypt(loginBean.getPassword());
	    
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    Query query=session.createQuery("from AccountHolder where name=:usern and password=:pass");
	    query.setParameter("usern", username);
	    query.setParameter("pass", password);
	    AccountHolder accountHolder=(AccountHolder)query.uniqueResult();
	    if(accountHolder!=null) {
	    	return "Validuser";
	    }
	    session.close();
	    return "Invalid user";
	}
	
	    
	 
}
