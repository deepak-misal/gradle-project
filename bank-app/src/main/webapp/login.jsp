<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<div class="container" style="border:5px solid;padding:40px;width: 500px;margin-top:100px">
<h2 style="text-align: center;">Account Login Form</h2><br>
<form name="form" action="login" method="POST">
<table align="center">
	<tr>
		<td>Username: </td>
		<td><input type="text" name="username"></td>
	</tr>
	<td bgcolor="#FFFFFF" style="line-height:10px;" colspan=3>&nbsp;</td>
	<tr>
		<td>Password: </td>
		<td><input type="text" name="password"></td>
	</tr>
	<td bgcolor="#FFFFFF" style="line-height:10px;" colspan=3>&nbsp;</td>
	<tr>
		<td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
    </tr>
    <td bgcolor="#FFFFFF" style="line-height:10px;" colspan=3>&nbsp;</td>
    <tr>
    	<td><a href="register">I don't have an account</a></td>
    </tr>
    <td bgcolor="#FFFFFF" style="line-height:10px;" colspan=3>&nbsp;</td>
    <tr>
        <td></td>
        <td><input type="submit" value="Login" class="btn btn-primary"></input><input type="reset" value="Reset" class="btn btn-danger"></input></td>
    </tr>
</table>
</form>
</div>
</body>
</html>