<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customers Directory</title>
</head>
<body>

	<div class="container">
		<h3>Customer Relationship Management</h3>
		<hr>
		<!-- Add a search form -->
		<form action="/CustomerRelationshipManagement/customers/search" class="form-inline">
			<!-- Add a button -->
			<a href="showFormForAdd" action ="showFormForAdd.jsp" class="btn btn-primary btn-sm mb-3"> Add Customer </a>
		</form>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					
					<th>firstname</th>
					<th>lastname</th>
					<th>email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${listcustomer}" var="tempCustomer">
					<tr>
						
						<td>${tempCustomer.firstname}</td>
						<td>${tempCustomer.lastname}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- Add "update" button/link --> <a
							href="showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false"> Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>