<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Browse</title>
</head>
<body>
<h1>Browse Page</h1>
<s:set var="varMsg" value="msg" />
<h1><s:property value="varMsg" /></h1><br>
<s:set var="varTime" value="time"/>
<h1><s:property value="varTime"/></h1>
</body>
</html>