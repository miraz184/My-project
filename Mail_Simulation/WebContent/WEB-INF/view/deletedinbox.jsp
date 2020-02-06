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
<h1 align="center">===========Deleted Message===========</h1><br>
 <hr>
 <hr>
<button align="left" ><a   href="Home">Home</a></button>	
<table style="background-color: blue"; border='1' align='center'>
<tr><th>Deleted Message</th></tr>
<c:forEach var="dto" items="${list}">
<tr><td>${dto.getDeleteinbx()}</td></tr>
</c:forEach> 
</table>
<hr>
<hr>
</body>
</html>