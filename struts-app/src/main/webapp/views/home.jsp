<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HOME</h1>
<s:set var="varMsg" value="name" />
<s:iterator  begin="0" end="10">
	<h3><s:property value="varMsg" /></h3>
</s:iterator>
</body>
</html>