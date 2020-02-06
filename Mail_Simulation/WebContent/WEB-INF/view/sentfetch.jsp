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
<%-- <button align="left" ><a   href="Home">Home</a></button>
<table style="background-color: blue"; border='1' align='center'>
<tr><th>Message</th> <th>To</th></tr>
<c:forEach var="dto" items="${list}">
<tr><td>${dto.getInbox()}</td><td>${dto.getSent()}</td></tr>
</c:forEach>
</table>
 <hr> --%>
<!-- //<hr> -->
<h1 align="center">==========Sent Message===========</h1>
<button align="left" ><a   href="Home">Home</a></button>
	<hr>
	<hr>
	<form action=" " align="center" method="post">
		<div style="background-color: gray";>
		
			<label for="to">To</label> <br> <input 
				name="to"  value="${mailobj.getSent()}" >

		</div>
		<div style="background-color: gray";>
		
			<label for="to">Subject</label> <br> <input
				name="to" value="${mailobj.getSubject()}">

		</div>

		<div style="background-color: gray";>
			<label for="msg">Message</label> <br>
		 <input  name="msg"  value="${mailobj.getInbox()}"  >
		</div>
		

	</form>
	<hr>
	<hr>


</body>
</html>
