<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cs320.hw1.models.*" %>
<%@ page import="cs320.hw1.models.UserType" %>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE> Manager Home </TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<script src="../bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class = "well">
		<div class="page-header"><h1>Lease Management System    </h1></div>
			<c:if test="${username != null && username != '' && 'ADMIN' eq userType }">
			<p  class="lead">Welcome, <c:out value="${username }"></c:out> | <a href = 'Logout'> Signout </a>	</p>	
			<p><a href = 'ManagerHome'> HOME </a> | <a href = 'ViewApartment'> View Apartment </a></p>
			<p class="text-left">
				 Pay Rent:</p>
			<table class="table table-striped">
				<tr><th>Apartment No </th><th>UserName </th><th>Rent</th><th>Rent Paid</th><th>Month</th><th>Year</th><th>Operation</th></tr>
			 <c:forEach items="${payRentBean}" var="payRent">
			 	<tr>
			 	
			 	<td><c:out value="${payRent.apartmentNo}"></c:out></td>
			 	<td><c:out value="${payRent.username}"></c:out></td>
			 	<td><c:out value="${payRent.rent}"></c:out></td>
			 	<form action = 'PayRent' method = 'post'>
						<input type = 'hidden' name = 'leaseID' id = 'leaseID' value ='${payRent.leaseID}' />
					<td><input type = 'text' name = 'rentPaid' id= 'rentPaid' /> </td>
					<td> 
						<select id = 'month' name = 'month'>
							<c:forEach items="${months}" var="month"> 
								<option value = "${month.month}"><c:out value = "${month.month }"></c:out></option>
							</c:forEach>
						</select>
					</td>
					<td> 
						<select id = 'year' name = 'year'>
							<c:forEach items="${years}" var="year">
								<option value = "${year.year}"><c:out value = "${year.year }"></c:out></option>
							</c:forEach>
						</select>	
					</td>
					<td><input type = "submit" value = 'Done'/></td>
					</form>
			 	</tr>
			 
			 </c:forEach>
			</table>
			</c:if>
			<c:choose>
				 <c:when test="${'USER' eq userType}">
			 	<c:out value="You are not admin, please login as a admin !!!" />
			 </c:when>
			</c:choose>
</div>
</div>
</body>
</html>