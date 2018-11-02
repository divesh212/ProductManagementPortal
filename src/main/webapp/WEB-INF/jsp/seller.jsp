<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="main.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">Company Name</th>
				<th scope="col">Owner Name</th>
				<th scope="col">Status</th>
				<th scope="col"></th>
				<th scope="col"></th>

			</tr>
		</thead>
		<tbody>
		<c:forEach items="${sellers}" var="seller">
			<tr>
				<td>${seller.id}</td>
				<td>${seller.companyName}</td>
				<td>${seller.ownerName}</td>
				<td>${seller.statusId}</td>
				<td><input type="checkbox" name="cbox"></td>
				<td><a href="seller/${seller.id}">Details</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>