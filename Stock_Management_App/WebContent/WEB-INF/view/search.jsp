<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">welcome to search page</h1>
<h4  align="right" style="color:red">${mlist}</h4> 
<hr>
<div align="right" style="background-color:blue">		
<button><a   href="add">Add Product</a></button>
<button><a   href="avail">Show Available</a></button>
<button><a   href="cart_page">Show_Cart </a></button>
<button><a   href="logout">Log Out</a></button>
</div>
<hr>
<hr>
<form action="searchproduct" align="center" method="post">
<div>
<label for="search">Search Product by Name</label> <br> <input type="text" name="search" id="search">
</div>
<div>
<button  type="submit">Submit</button>
</div>
</form>
<hr>
</body>
</html>