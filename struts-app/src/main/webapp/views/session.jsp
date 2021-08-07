<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session</title>
</head>
<body>
<h1>Session Page</h1>
<s:set var="varOld" value="oldCount"/>
<h1>Old:<s:property value="varOld"/></h1>
<h1>New:<s:property value="%{#session.Counter}"/></h1>
</body>
</html>