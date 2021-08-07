<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<div class="container" style="border:5px solid;padding:40px;">
<h2 style="text-align: center;">Transaction Page</h2><br>
<form name="form" action="transaction" method="POST">
<table align="center">
	<tr>
		<td>Enter amount</td>
		<td><input type="text" name="amount"></td>
	</tr>
	<td bgcolor="#FFFFFF" style="line-height:10px;" colspan=3>&nbsp;</td>
	<tr>
		<td><input type="radio" name="transaction" value="D"><lable for="D">Deposite</lable></td>
		<td><input type="radio" name="transaction" value="W"><lable for="W">Withdraw</lable></td>
	</tr>
	<td bgcolor="#FFFFFF" style="line-height:10px;" colspan=3>&nbsp;</td>
    <tr>
        <td></td>
        <td><input type="submit" value="Submit" class="btn btn-primary"></input></td>
    </tr>
</table>
</form>
</div>
</body>
</html>