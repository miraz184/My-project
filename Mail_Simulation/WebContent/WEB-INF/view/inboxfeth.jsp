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

<%-- <table style="background-color: blue"; border='1' align='center'>
<tr><th>Message</th> <th>From</th></tr>
<c:forEach var="dto" items="${list}">
<tr><td>${dto.getInbox()}</td><td>${dto.getMailFrom()}</td></tr>
</c:forEach> --%>

<h1 align="center">==========Inbox Message===========</h1>
<button align="left" ><a   href="Home">Home</a></button>
	<hr>
	<hr>
	<form action=" " align="center" style="background-color: gray"; method="post">
		<div style="background-color: gray";>
		
			<label for="to">From</label> <br> <input 
				name="to"  value="${mailobj.getMailFrom()}" >

		</div>
		<div style="background-color: gray";>
		
			<label for="to">Subject</label> <br> <input
				name="to" value="${mailobj.getSubject()}">

		</div>

		<div style="background-color: gray";>
			<label for="msg">Message</label> <br>
		 <input  name="msg"  value="${mailobj.getInbox()}"  >
		</div>
		<!-- <div style="margin-top: 10px;">
			<input type="Submit" value="Send">
		</div> -->



	</form>
</table>
 <hr>
<hr>
</body>
</html>
