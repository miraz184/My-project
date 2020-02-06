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
<h1 align="center">Stocks Available</h1>
<div align="right">	
<button><a   href="add">Add Product</a></button>
<button><a   href="searchp">Search Product</a></button>
<button><a   href="cart_page">Show_Cart </a></button>
<button><a   href="logout">Log Out</a></button>
</div>
<hr>
<hr>
<table style="background-color: blue"; border='1' align='center'>
<tr><th>Product ID</th><th>Product Name</th> <th>Company</th><th>Quantity</th><th>Price</th><th>Add</th></tr>
<form action="Add_Cart" align="center" method="post">
<c:forEach var="dto" items="${list}">
<tr>
<td><center><input type="text" name="pid"  value="${dto.getPid()}"></center></td>
<td><center><input type="text" name="name"  value="${dto.getName()}"></center></td>
<td><center><input type="text" name="company"  value="${dto.getCompany()}"></center></td>
<td><center><input type="text" name="quantity"  value=""></center></td>
<td><center><input type="text" name="price"  value="${dto.getPrice()}"></center></td>
<td><center><input type="submit"   value="Add_to_cart"></center></td>
</tr>
</form>
</c:forEach>
</table>
<hr>
<hr>


</body>
</html>