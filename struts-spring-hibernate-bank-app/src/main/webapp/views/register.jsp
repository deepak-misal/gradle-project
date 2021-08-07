<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
<h1>Add Account</h1>
	<s:form action = 'add' method="POST">
		<s:textfield name = 'accountHolder.name' label = 'name'/>
		<s:textfield name = 'accountHolder.balance' label = 'balance'/>
		<s:textfield name = 'accountHolder.password' label = 'password'/>
		<s:submit action="add"/>
	</s:form>
<a href="loginform">Already have an account</a>
</body>
</html>