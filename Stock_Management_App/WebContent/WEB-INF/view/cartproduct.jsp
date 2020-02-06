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
<h1 align="center">===============Cart===============</h1>
<div align="right" >		
<button><a   href="add">Add Product</a></button>
<button><a   href="searchp">Search Product</a></button>
<button><a   href="avail">Show Available</a></button>
<button><a   href="logout">Log Out</a></button>
</div>

<hr>
<hr>
<table style="background-color: blue"; border='1' align='center'><form action="fetch_Cart" align="center" method="post">
<tr><th>Oreder_Id</th> <th>Product_Id</th><th>Product_Name</th><th>Company</th><th>Category</th><th>Unit Price</th><th>Quantity</th><th>Total_Price</th><th>Price_with_gst</th></tr>
<c:forEach var="dto" items="${list}">
<tr><td><center>${dto.getOid()}</center></td>
<c:forEach var="pdto" items="${dto.getPlist()}">
<td><center>${pdto.getPid()}</center></td>
<td><center>${pdto.getName()}</center></td>
<td><center>${pdto.getCompany()}</center></td>
<td><center>${pdto.getCategory()}</center></td>
<td><center>${pdto.getPrice()}</center></td>
<td><center>${dto.getTotal_price()/pdto.getPrice()}</center></td>

</c:forEach>
<td><center>${dto.getTotal_price()}</center></td>
<td><center>${dto.getTotal_price_with_gst()}</center></td>
</tr>
</c:forEach>
</table>
<hr>
<hr>
</body>
</html>


