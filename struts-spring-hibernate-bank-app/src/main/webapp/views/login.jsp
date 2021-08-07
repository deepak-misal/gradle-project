<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="lightblue">
<h1>Login Page</h1>
<s:form action="login" method="POST">
	<s:textfield name="loginBean.username" label="username"/>
	<s:textfield name="loginBean.password" label="password"/>
	<s:submit action="login" type="submit"/>
	
</s:form>
<a href="form">Don't have an account</a>
</body>
</html>