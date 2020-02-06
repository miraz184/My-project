<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Login Page</h1>
 <h4  align="right" style="color:red">${msg}</h4> 
<hr>
<form action="loginValidation" align="center" method="Post" >
			<div>
				<label for="email">Email</label> <br>
				 <input type="email"name="email" id="email">
					
			</div>

			<div>
				<label for="password">Password</label> <br> 
					<input type="password" name="password" id="password">
			</div>
			<div style="margin-top: 10px;">
				<input type="Submit" value="Login">
			</div>

			
	</div>
		</form>



</form>

</body>
</html>