<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"> confirm password</h1>
<h4>
<div style="background-color: blue";>
<h3 align="center"><button><a href="login">Login</a></button>
<button><a href="registration">Registration</a></button></h3>
</div>
</h4>
<hr>
<div style="color:red;">${pass}</div>
<br>
<br>
<br>

<div align="center">
<fieldset>
<style>
fieldset{
width:350px;
height:195px;

}

</style>
<form action="ForgetConfirm" method="post" style="margin-top: 20px; margin-bottom: 30px">
<input type="password" name="password1" placeholder="Enter new password" required="required" style="width: 250px; height: 20px"/><br><br>
<input type="password" name="password2" placeholder="Enter again" required="required" style="width: 250px; height: 20px"/><br><br>
<input type="submit" value="submit" style="width: 160px; height: 40px" />
</form>
</fieldset>
</div>
</body>
</html>