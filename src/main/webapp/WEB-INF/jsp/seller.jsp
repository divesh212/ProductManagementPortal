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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<form action="/admin/seller" method="POST">

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
						<td>
						<c:if test="${seller.statusId==1}">
							<input type="checkbox" name="cbox" value="${seller.id}">
						</c:if>
						</td>
						<td><a href="seller/${seller.id}">Details</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="Approve">
	</form>

	<form action="/admin/seller" method="GET">
		<h3>Search by</h3>
		<input type="radio" name="searchKey" value="COMPANY_NAME"
			${companyChecked} />Company Name <br /> <input type="radio"
			name="searchKey" value="OWNER_NAME" ${ownerChecked} />Owner Name <br />
		<input type="radio" name="searchKey" value="PHONE" ${phoneChecked} />Phone
		Number <br /> serach here: <input type="text" name="searchQuery"
			value="${searchQuery}">

		<h3>Choose status:</h3>
		<input type="radio" name="status" value="NEED_APPROVAL"
			${needApprovalChecked} />NEED_APPROVAL <br /> <input type="radio"
			name="status" value="APPROVED" ${approvedChecked} />APPROVED<br />
		<input type="radio" name="status" value="REJECTED" ${rejectedChecked} />REJECTED
		<br />

		<h3>Sort By</h3>
		<input type="radio" name="sortBy" value="id" ${idChecked} />Seller ID<br />
		<input type="radio" name="sortBy" value="createdAt"
			${createdAtChecked} />Registration Time<br /> <input type="submit"
			value="pessMe">
	</form>

</body>
</html>