<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.techlabs.model.AccountHolder" %>
    <%@ page import="com.techlabs.repository.BankRepository" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	.navbar-collapse{
		background-color:dodgerblue;
		border:5px solid;
	}
	a{
	font-size: 15px;
    padding: 20px;
   	margin: 10px;
    margin-left: 30px;
	}
	.nav{
    text-color: white;
	}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<div nav class="navbar navbar-default navbar-custom" role="navigation">
	<div nav class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
	        <li><a href="#" style="color:white;">BANK-APP</a></li>
	    </ul>
  		<ul class="nav navbar-nav navbar-right">
    		<li><a href="passbook" style="color:white;"><i class="glyphicon glyphicon-list-alt"></i> Passbook</a></li>
    		<li><a href="trans" style="color:white;"><i class="glyphicon glyphicon-transfer"></i> Transaction</a></li>
    		<li><a href="form" style="color:white;"><i class="glyphicon glyphicon-off"></i> Register</a></li>
		    <%
		    	String name1=(String)session.getAttribute("Admin");
		    	if(name1!=null){
		    		out.println("<li><a href='logout' style='color:white;'><i class='glyphicon glyphicon-log-in'></i> Log Out</a></li>");
		    	}
		    	else{
		    		out.println("<li><a href='loginform' style='color:white;'><i class='glyphicon glyphicon-log-in'></i> Log In</a></li>");
		    		
		    	}
		    %>
  	</ul>
  </div>
</div>
<%	
	BankRepository repo=new BankRepository();
	String name=(String)session.getAttribute("Admin");
	int balance=repo.getBalance(name);
	if(name!=null){
		
		out.println("<h1 class='w3-cursive w3-large'>Account Holder's Name:  "+name+"</h1>");
		out.println("<h1 class='w3-cursive w3-large'>Account Holder's Balance:  "+balance+"</h1 	>");
		
	}
	
%>
</body>
</html>