<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">*****************Sign Up******************</h1>
<h1 align="center" ><label  style="background-color: red";>${msg }</label></h1>
<h3 align="right"><button><a href="login">Login</a></button>
<hr>
	<form action="regmail" align="center" method="post">
			
			<div style="background-color: green";>	<label for="username" >
			
				Username</label> <br> <input type="text"name="username" id="username" required="required">
					
			</div>

			<div style="background-color: green";><label for="password">
				 
					Password</label> <br><input type="password" name="password" id="password" required="required">
			</div>

			
			<div style="background-color: green";><label for="name">

				Email Id</label> <br> <input type="email" name="email" id="email" required="required"><br>
			</div>
			
			<!-- <div style="background-color: green";><label for="scrqn">

				 </label> <br> <input type="text" name="scrqn" id="scrqn" required="required">
			</div> -->
			<div style="background-color: green";>
			<select name='scrqn' id='scrqn' required="required" style="width: 140px; height: 20px">
			<option value='' selected disabled style="background-color: green";>Security Question</option>
			<option value="1">What's your pet name?</option>
			<option value="2">Who's your favourite actor?</option>
			<option value="2">Who's your favourite food?</option>
			</select>
			</div>
			
			<div style="background-color: green";><label for="scrans">

				Answer</label> <br> <input type="text" name="scrans" id="scrans" required="required">
			</div>

			<div style="background-color: green">
				<button  type="submit">Sign Up</button>
			</div>
		</form>
<hr>

</body>
</html>