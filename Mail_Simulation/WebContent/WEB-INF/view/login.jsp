<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">*******************Login Page******************</h1>
	<h4 align="right">${msg}</h4>
	<hr>
	<form action="loginmail" align="center" method="Post">
		<!-- <div style="background-color: blue";>
			<label for="username">Username</label> <br> <input type="text"
				name="username" id="username">

		</div> -->
		<div style="background-color: blue";>
			<label for="name"> Email Id</label> <br> <input type="email"
				name="email" id="email" required="required">
		</div>
		<div style="background-color: blue";>
			<label for="password">Password</label> <br> <input
				type="password" name="password" id="password">
		</div>
		<div style="background-color: blue" ; style="margin-top: 10px;">
			<input type="Submit" value="Login">
		</div>
<button align="left" ><a   href="forgetpass">forget password!</a></button>
		<hr>

	</form>





</body>
</html>