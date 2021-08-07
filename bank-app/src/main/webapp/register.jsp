<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<h2 style="text-align: center;">Account Registration Form</h2><br>
<form action="register" method="POST" class="form-horizontal">
	<div class="form-group">
		<label for="rollNo" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<input type="text" id="name" name="name" class="form-control" required><br>
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Opening Balance:</label>
		<div class="col-sm-10">
			<input type="text" id="obalance" name="obalance" class="form-control" required><br>
		</div>
	</div>
    <div class="form-group">
		<label for="cgpa" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<input type="text" id="pass" name="pass"  class="form-control" required><br>
		</div>
	</div> 
	<div class="form-group">
		<label for="location" class="col-sm-2 control-label">Re-Enter Password:</label>
		<div class="col-sm-10">
			<input type="text" id="repass" name="repass" class="form-control"required><br>
		</div>
	</div>   
	<div class="form-group">  
		<div class="col-sm-10">
			<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
			<span><a href="login" class="col-sm-2 control-label">Already have an account</a></span>
		</div>
	</div>
    <div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			 <button type="submit" formmethod="POST" class='btn btn-primary'>Register</button>    
		</div>
	</div>           
       
</form>
</body>
</html>