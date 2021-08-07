package com.techlabs.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.techlabs.model.LoginBean;

public class LoginRepository {
	
	public String hashConverter(String password) {
		String hashpass=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con;
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banks?" +
					 "user=root&password=root");
			Statement stmt= (Statement) con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT PASSWORD FROM BANK_MASTER WHERE PASSWORD=PASSWORD('"+password+"');");
			while(rs.next()) {
				hashpass=rs.getString("PASSWORD");
			}
			return hashpass;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hashpass;
		
	}

	public String authenticateUser(LoginBean loginBean){
		System.out.println("In Auth");
		String userName = loginBean.getUsername();
	    String password = loginBean.getPassword();
	    
	    Connection con = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	    
	    String hash=hashConverter(password);
	    if(hash==null) {
	    	return "Invalid Password";
	    }
	    
	    String userNameDB = "";
	    String passwordDB = "";
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banks?" +
					 "user=root&password=root");
	        statement = (Statement) con.createStatement();
	        resultSet = statement.executeQuery("SELECT NAME,PASSWORD FROM BANK_MASTER");
	 
	        while(resultSet.next())
	        {
	            userNameDB = resultSet.getString("NAME");
	            passwordDB = resultSet.getString("PASSWORD");
	            
	            if(userName.equals(userNameDB) && hash.equals(passwordDB))
	            return "Validuser";
	            
	        }
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "Invalid user credentials";
		
	}
	    
	 
}
