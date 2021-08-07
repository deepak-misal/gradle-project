<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h1>Display Page</h1>
<table>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Cgpa</th>
</tr>

<s:iterator value="students">
<tr>
        <td><s:property value="id" /></td>
        <td><s:property value="name" /></td>
        <td><s:property value="cgpa" /></td>
        </tr>
</s:iterator>

</table>
<s:property value="studentList"/>
</body>
</html>