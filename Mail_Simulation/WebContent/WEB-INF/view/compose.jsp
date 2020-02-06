<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 align="right">${msg}</h4>
	<h1 align="center">==========Compose===========</h1>
	<button align="left" ><a   href="Home">Home</a></button>
	<hr>
	<hr>
	<form action="composemail" align="center" method="post">
		<div style="background-color: gray";>
		
			<label for="to">To</label> <br> <input type="text"
				name="to" id="to">

		</div>
		<div style="background-color: gray";>
		
			<label for="Subject">Subject</label> <br> <input type="text"
				name="Subject" id="Subject">

		</div>
		

		<div style="background-color: gray";>
			<label for="msg">Message</label> <br>
			<textarea rows="10" cols="40" type="textarea" name="msg" id="msg"></textarea>
			
		</div>
		<div style="background-color: gray"; style="margin-top: 10px;">
			<input type="Submit" value="Send">
		</div>



	</form>

<hr>
<hr>



</body>
</html>