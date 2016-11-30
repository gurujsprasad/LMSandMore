<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="cs320.hw1.*" %>
<%@ page import="cs320.hw1.models.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE>ViewFeedBack</TITLE>
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

			<c:forEach items="${feedback }" var="feedback">
			<p><a href = 'ManagerHome'> HOME </a>  >>  <a href = 'ViewApartment'> View Apartment</a>
	  		>>  <a href = 'ViewAppointment?apartmentID=${feedback.apartmentID}'> View Appointment</a>
		</p>
		<h4>VIEW FEED BACK FORM</h4>
			<table class="table table-striped">
				
					<tr><td>Application Number</td><td>${feedback.applicationID}</td></tr>
					<tr><td>Apartment Number</td><td>${feedback.apartmentNumber}</td></tr>
					<tr><td>Lease Termination Date</td><td>${feedback.leaseTermintationDate}</td></tr>
					<tr><td>Lease Holder Name</td><td>${feedback.leaseHolderName}</td></tr>
					<tr><td>List of Documents</td><td>${feedback.leaseDocuments}</td></tr>
					<tr><td>Rent</td><td>${feedback.rent}</td></tr>
					<tr><td>Deposit</td><td>${feedback.deposit}</td></tr>	
				
				</table>
				<p style='color:red;font-weight: bold;font-size: 20px'><a href = 'ViewAppointment?apartmentID=${feedback.apartmentID}'> View Appointment</a></p>
			</c:forEach>
	
  </div>
</div>
	
	<c:choose>
		<c:when test="${'USER' eq userType}">
		 	<c:out value="You are not admin, please login as a admin !!!" />
		 </c:when>
	</c:choose>
</body>
</html>