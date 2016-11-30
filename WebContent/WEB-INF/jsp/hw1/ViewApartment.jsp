<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cs320.hw1.models.*" %>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE>View Apartment</TITLE>
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
		<p><a href = 'ManagerHome'> HOME </a> | <a href = 'Logout'> Signout </a></p>
	
		<div><h4>Apartment Details</h4></div> <div style = 'float: right'> <a style = 'color:red' href = "PayRent">Pay Rent</a> |  <a style = 'color:red'  href = 'ShowRentHistory'> Show Rent History </a></div>
		<table class="table table-striped">
		<tr><th>Apartment No</th><th>Apartment Type</th><th>Facility</th><th>Max People</th><th>Rent</th><th>Deposit</th><th>Vacant</th><th>Change Availibility</th><th>Appointments</th></tr>
		<c:forEach items="${ apartments }" var="apartment">
			<tr><td><c:out value="${apartment.apartmentNumber}"></c:out></td>
				<td><c:out value="${apartment.apartmentType}"></c:out></td>
				<td><c:out value="${apartment.facility}"></c:out></td>
				<td><c:out value="${apartment.maxPeople}"></c:out></td>
				<td><c:out value="${apartment.rent}"></c:out></td>
				<td><c:out value="${apartment.deposit}"></c:out></td>
				<td><c:out value="${apartment.vacancy}"></c:out></td>
				<td>
					<c:if test="${ apartment.vacancy == 'NO' || apartment.vacancy == 'RENTED'}">
					<a href = 'MakeAvailable?aptID=${apartment.apartmentID}'>Make Available</a>
					</c:if>
				</td>
				<td>
					 <c:if test="${ apartment.vacancy == 'YES'}">
						<a href = 'ViewAppointment?apartmentID=${apartment.apartmentID}'> View </a>
					</c:if>
					<c:if test="${ apartment.vacancy == 'RENTED'}">
						<a href = 'ViewAppointment?apartmentID=${apartment.apartmentID}'> View Feed Back </a>
					</c:if> 
				</td>
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