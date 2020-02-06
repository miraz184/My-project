<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Enter Product Details</h1>
<button align="right"><a   href="login">Login</a></button>

<hr>
	<form action="registration" align="center" method="post">
			

			<div style="background-color: green";><label for="firstname">

				 firstname</label> <br> <input type="text" name="firstname" id="firstname">
			</div>

			<div style="background-color: green";><label for="lastname">

				 lastname</label> <br> <input type="text" name="lastname" id="lastname">
			</div>

			<div style="background-color: green";><label for="email">

				email</label> <br> <input type="email" name="email" id="email">
			</div>
			
			<div style="background-color: green";>
				<label for="userName">Username</label> <br>
				 <input type="text"name="userName" id="userName">
					
			</div>

			<div style="background-color: green";>
				<label for="password">Password</label> <br> 
					<input type="password" name="password" id="password">
			</div>

			<div>
				<button style="background-color: blue" type="submit">Sign Up</button>
			</div>

			

		</form>

</form>
</body>
</html>