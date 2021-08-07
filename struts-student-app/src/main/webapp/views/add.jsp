<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Info</title>
</head>
<body>
<h2>Roll No:<s:property value="student.rollNo"/></h2>
<h2>Name:<s:property value="student.name"/></h2>
<h2>Cgpa:<s:property value="student.cgpa"/></h2>
<a href="display">Display List</a>
</body>
</html>