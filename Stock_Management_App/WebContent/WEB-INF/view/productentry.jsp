<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Enter Product Details</h1>
	<div align="right">
		<button>
			<a href="searchp">Search Product</a>
		</button>
		<button>
			<a href="avail">Show Available</a>
		</button>
		<button>
			<a href="edit">Edit </a>
		</button>
		<button>
			<a href="logout">Log Out</a>
		</button>
	</div>
	<hr>
	<hr>
	<form action="addProduct" align="center" method="post">


		<div style="background-color: green";>
			<label for="name"> Name</label> <br> <input type="text"
				name="name" id="name">
		</div>

		<div style="background-color: green";>
			<label for="category"> Category</label> <br> <input type="text"
				name="category" id="category">
		</div>

		<div style="background-color: green";>
			<label for="company"> Company</label> <br> <input type="text"
				name="company" id="company">
		</div>



		<div style="background-color: green";>
			<label for="quantity"> Quantity</label> <br> <input
				type="number" name="quantity" id="quantity">


		</div>

		<div style="background-color: green";>
			<label for="price">Price</label> <br> <input type="number"
				name="price" id="price">

		</div>


		<div style="background-color: green">
			<button type="submit">Entry</button>
		</div>



	</form>
	<hr>
	<hr>

</body>
</html>