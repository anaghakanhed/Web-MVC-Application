<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container bg-light" align="center">

		<h2>
			<font color="gray">Product Application</font>
		</h2>
		<p>
			<font color="red">${msg}</font>
		</p>
		<form:form action="product" modelAttribute="p" method="POST">
			<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td><form:input path="qty" /></td>
				</tr>

				<tr>
					<td><input type="Submit"  class="btn btn-outline-info value="Submit" ></td>
				</tr>
				</table>
			<a href="products">View Products</a>
		
		</form:form>
		
	</div>
	
</body>
</html>