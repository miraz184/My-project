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





	<h1 align="center">==========Draft===========</h1>
	<button align="left" ><a   href="Home">Home</a></button>
	<hr>
	<hr>
	<form action="mailcompose" align="center" method="post">
		<div style="background-color: gray";>
		
			<label for="to">To</label> <br> <input type="text"
				name="to" value="${mailobj.getSent()}">

		</div>
		<div style="background-color: gray";>
		
			<label for="sub">Subject</label> <br> <input 
				name="sub" value="${mailobj.getSubject()}">

		</div>

		<div style="background-color: gray";>
			<label for="msg">Message</label> <br>
		 <input  name="msg"  value="${mailobj.getDraft_message()}"  >
		</div>
		<div style="background-color: gray"; style="margin-top: 10px;">
			<input type="Submit" value="Send">
		</div>
	</form>
	<hr>
	<hr>




</body>
</html>