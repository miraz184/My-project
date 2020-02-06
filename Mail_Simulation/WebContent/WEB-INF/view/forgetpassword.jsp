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

<h1 align="center">===========Security===========</h1><br>
<h4 align="right">${msg}</h4>
<button align="left" ><a   href="Home">Home</a></button>

 <hr>
 <hr>

<form action="forgetpassword" align="center" method="Post">
		
		</div> 
		<div style="background-color: blue";>
			<label for="old_email"> Enter Your Email Id</label> <br> <input type="old_email"
				name="old_email" id="old_email" required="required">
		</div>
		<div style="background-color: blue";>
			<label for="new_email"> New Password</label> <br> <input type="password"
				name="new_email" id="new_email" required="required">
		</div>
		<div style="background-color: blue" ; style="margin-top: 10px;">
			<input type="Submit" value="submit">
		</div>

		

	</form>
<hr>
<hr>
	
<%-- <table style="background-color: blue"; border='1' align='center'>
<tr><th>Message</th> <th>Draft</th>  </tr>
<c:forEach var="dto" items="${msg}">
<tr><td>${dto.getDraft_message()}</td><td>${dto. getDraft()}</td></tr>
</c:forEach> 
</table> --%>

</body>
</html>