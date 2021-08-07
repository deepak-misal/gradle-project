<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
<h1>Transaction Page</h1>
<s:form metho="post" action="transaction">
	<s:textfield name="transaction.amount" label="amount"/>
	<s:radio name="transaction.type" label="type" list="#{'D':'D','W':'W'}"/>
	<s:submit action="transaction"/>
</s:form>
</body>
</html>