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
<TITLE>FeedBackRentOut</TITLE>
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
		<c:forEach items="${ feebBackDetails }" var="feebBackDetail">
		<h4 style='color: GREEN'>Feed back for the rented apartment for application number:<c:out value=" ${feebBackDetail.applicationID}"></c:out> </h4>
		
		<c:if test="${feedbackDateInvalid != null and feedbackDateInvalid != ''}">
			<div class="alert alert-danger"><p><c:out value="${feedbackDateInvalid}" /> </p></div>
			<c:set var="feedbackDateInvalid" scope="session" value="${''}"/>
		</c:if>
		
			<table cellspacing = 10>
				<form action= 'FeedBack' method = 'post' >
				<input type ="hidden" name="applicationNumber" id="applicationNumber" value='${feebBackDetail.applicationID }'/>
				<input type ="hidden" name="apartmentID" id="apartmentID" value='${feebBackDetail.apartmentID }'/>
				<tr><td>Apartment Number</td><td><input type='text' name = 'apartmentNumber' id = 'apartmentNumber' readonly value='${feebBackDetail.apartmentNumber}'/></td></tr>
				<tr><td>Lease Holder Name</td><td><input type='text' name = 'leaseName' id = 'leaseName' value='${feebBackDetail.leaseHolderName}' /></td></tr>
				<tr><td>List of Documents</td><td><textarea id = 'documents' name = 'documents' rows = '5' cols = '30'> </textarea></td></tr>
				<tr><td>Rent</td><td><input type='text' name = 'rent' id = 'rent' value = '${feebBackDetail.rent }'/></td></tr>
				<tr><td>Deposit</td><td><input type='text' name = 'deposit' id = 'deposit' value = '${feebBackDetail.deposit }'/></td></tr>
				<tr><td>Lease Termination Date</td><td><input type='text' name = 'leaseTerminationDate' id = 'leaseTerminationDate'/>(Please enter date in mm/dd/yyyy hh:mm:ss e.g. 10/07/2015 05:00:00)</td></tr>
				<tr><td><input type = 'submit' name = 'FeebBack' value = 'Feeb Back'/></td>
				<td><input type = 'reset' name = 'clear' value = 'Clear'/></td></tr>
			</form>
		</table>
			</c:forEach>
	</c:if> 
	
	<c:choose>
			 <c:when test="${username == null || username == '' || 'USER' eq userType }">
		 	<c:out value="You are not admin, please login as a admin !!!" />
		 </c:when>
		</c:choose>
</div>
</div>
</body>
</html>