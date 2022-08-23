<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search result</title>
<%@include file="./base.jsp"%>
</head>
<body>
	<h2 align="center">${Message}</h2>
	<div class="row">

		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Address</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<tr>

					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.address}</td>
					<td><a href="editEmployee/${emp.id}" class="btn btn-warning">
							Edit </a></td>
					<td><a href="deleteEmployee/${emp.id}" class="btn btn-danger">
							Delete </a></td>
				</tr>

			</tbody>
		</table>

	</div>

</body>
</html>