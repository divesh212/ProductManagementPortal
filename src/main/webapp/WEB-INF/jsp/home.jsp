<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/admin/logout" method="POST">
		<button type="submit">Logout</button>
	</form>
	<c:if test="${not empty admin}">
		<h2>Hii ${admin.username}</h2>
	</c:if>
	<c:if test="${empty admin}">
		
	</c:if>
	
	<form action="/admin/seller" method="GET">
		<button type="submit">Seller</button>
	</form>
	
	<form action="/admin/product" method="GET">
		<button type="submit">Product</button>
	</form>
	
	<form action="/admin/category" method="GET">
		<button type="submit">Category</button>
	</form>
</body>
</html> --%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<style>
body {
	font-family: 'Raleway', sans-serif;
}

button {
	cursor: pointer;
	background-color: light-grey;
	border: 5px;
	outline: none !important;
}
.buttonss{
	margin-top: 200px;
	margin-left: 200px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light"
		style="box-shadow: 1px 1px #888888c5; padding-bottom: 1px; padding-top: 2px;">


		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Admin
						Panel </a></li>
		</div>
	</nav>

	<div class="row buttonss">
		<div class="col-md-4">
			<form action="/admin/seller" method="GET">
				<button class="btn" type="submit">Seller</button>
			</form>
		</div>

		<div class="col-md-4">
			<form action="/admin/product" method="GET">
				<button class="btn" type="submit">Product</button>
			</form>
		</div>

		<div class="col-md-4">
			<form action="/admin/category" method="GET">
				<button class="btn" type="submit">Category</button>
			</form>
		</div>
	</div>

</body>
</html>