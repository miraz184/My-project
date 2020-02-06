<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1  align="center" style="color:blue"> Welcome to  Menu</h1>
<table style="background-color: blue"; border='1' align='right'>
<tr><th><h2 align="right" style="color:white">${dto.getEmail()}</h2></th></tr></table><br><br><br><br><br>
 <h4  align="right" style="color:red">${msg}</h4> 



<hr>
<div align="center" style="background-color:blue">		
<button><a   href="add">Add Product</a></button>
<button><a   href="searchp">Search Product</a></button>
<button><a   href="avail">Show Available</a></button>
<button><a   href="cart_page">Show_Cart </a></button>
<button><a   href="edit">Edit </a></button>
<button><a   href="logout">Log Out</a></button>

</div>
<hr>
</body>
</html>