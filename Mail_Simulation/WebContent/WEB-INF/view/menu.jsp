<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1  align="center" style="color:blue"> Welcome to Mailing Menu</h1>
<table style="background-color: blue"; border='1' align='right'>
<tr><th><h2 align="right" style="color:white">${dto.getUsername()}</h2></th></tr></table><br><br><br><br><br>
<h4  align="right" style="color:red">${msg}</h4>



<hr>
<div align="center" style="background-color:blue">		
<button><a   href="compose">Compose</a></button>
<button><a   href="sentMail">Sent</a></button>
<button><a   href="inboxMail">Inbox</a></button>
<button><a   href="draftMail">Draft</a></button>
<button><a   href="forget">Change Password</a></button>
<button><a   href="logoutmail">Log Out</a></button>
<hr>
</div>
<hr>
</body>
</html>