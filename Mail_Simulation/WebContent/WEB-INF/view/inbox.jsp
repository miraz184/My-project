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
	<h1 align="center" >=============Inbox============</h1><br>
	
 <hr>
 <hr>
 <button align="left" ><a   href="Home">Home</a></button>|<button align="left" ><a   href="deletedinbox">Show_Deleted_inbox</a></button>
<table style="background-color: blue"; border='1' align='center'>
<tr><th>Message</th> <th>Inbox</th><th>Delete</th></tr>
<c:forEach var="dto" items="${msg}">
<tr>
<td>${dto.getInbox()}</td>
<td><a href="inboxfeth?did=${dto.getMid()}" style="color:black">${dto.getMailFrom()}</a></td>
<td><a href="delete?id=${dto.getMid()}"><button style="color:black">Delete</button></a></td>
</tr>
</c:forEach>
</table>
 <hr>
<hr>
</body>
</html>
