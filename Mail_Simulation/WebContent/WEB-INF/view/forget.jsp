<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Forget Password </h1>
<h4 align="right">
<div style="background-color: blue";>
<h3 align="center"><button><a href="login">Login</a></button>
<button><a href="registration">Registration</a></button></h3>
</div>
<hr>
<div style="color:red;">${forget}</div>
<br>
<br>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 215px;
}
</style>
<form action="ForgetPassword" method="post" style="margin-top: 20px; margin-bottom: 30px;">
<input type="email" name="email" placeholder="Enter email" required="required" style="width: 250px; height: 20px"/><br><br>
<select name='scrqn' id='scrqn' required='required' style="width: 250px; height: 30px" >
		<option value='' selected disabled style="background-color: green";>Security Question</option>
			<option value="1">What's your pet name?</option>
			<option value="2">Who's your favourite actor?</option>
			<option value="2">Who's your favourite food?</option>
</select>
<br>
<br>
<input type="text" name="scrans" placeholder="Enter Answer" required="required" style="width: 250px; height: 20px"/><br><br>
<input type="submit" value="Enter" style="width: 160px; height: 40px" />
</form>
</fieldset>
</div>
</h4>
</body>
</html>