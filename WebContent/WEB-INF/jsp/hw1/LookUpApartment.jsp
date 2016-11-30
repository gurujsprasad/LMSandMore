<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ page import="java.util.ArrayList" %>
<%@ page import="cs320.hw1.*" %>
<%@ page import="cs320.hw1.models.*" %>

<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE>LookUpApartment</TITLE>
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
	<c:if test="${username != '' and username != null }">
		<p class="lead"> Welcome, User ! <c:out value="${username}"></c:out>  |  <a href = 'Logout'>Signout</a></p>
		
		<table  class="table table-striped">
			<tr><td>Apartment ID</td><td>Apartment Type</td><td>Facility</td><td>Max People</td><td>Rent</td><td>Deposit</td><td>Operation</td><td>Appointment Date (By Manager)</td><td>Accept / Deny</td></tr>
			<c:forEach items="${ apartments}" var="apartment">
				<c:if test="${apartment.vacancy eq 'NO' || apartment.vacancy eq 'RENTED' }">
				<tr>
					<td>${apartment.apartmentNumber}</td> <td>${ apartment.apartmentType}</td>
					<td>${apartment.facility}</td><td>${ apartment.maxPeople}</td>
					<td>${ apartment.rent}</td><td>${ apartment.deposit}</td>
					<td><p style = 'color:red'>Not Vacant</p></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
				<c:set var="flag" value="false" scope="page"></c:set>
				<c:forEach items="${applications}" var="aplication">
					
					<c:if test="${userID == aplication.userID && apartment.apartmentID == aplication.apartmentID && aplication.status ne 'RENTED' }">
						<c:set var="flag" value="true" scope="page"></c:set>	
							<tr>
							<td>${apartment.apartmentNumber}</td> <td>${ apartment.apartmentType}</td>
							<td>${apartment.facility}</td><td>${ apartment.maxPeople}</td>
							<td>${ apartment.rent}</td><td>${ apartment.deposit}</td>
							<td></td><!-- this is operation row which is empty as appointment is already taken -->
							<td>${aplication.appointmentDate }</td>
						
						<c:if test="${aplication.status eq 'SCHEDULED' }">
							<td>
								<form action = 'DenyAppointment' method = 'post'>
									<input type = 'hidden' name ='applicationNumber' id ='applicationNumber' value= '${aplication.applicationID}'/>
									<input type = "submit" name = 'decision' id ='decision' value = 'ACCEPT'/>
									<input type = "submit"  name = 'decision' id ='decision' value ='REJECT'/>
								</form>
							</td>
						</c:if>
						<c:if test="${aplication.status eq 'REQUESTED' || aplication.status eq 'DENIED'  }">
							<td>
								<p style = 'color:green'>Appointment Request Sent</p>
							</td>
						</c:if>
						<c:if test="${aplication.status eq 'ACCEPTED'}">
							<td>
								<p style = 'color:green'>Appointment SCHEDULED</p>
								</td>	
						</c:if>
						</tr>
					</c:if>
				</c:forEach>
				
				<c:if test="${apartment.vacancy eq 'YES' && flag eq 'false'}">
					
					<tr>
						<td>${apartment.apartmentNumber}</td> <td>${ apartment.apartmentType}</td>
						<td>${apartment.facility}</td><td>${ apartment.maxPeople}</td>
						<td>${ apartment.rent}</td><td>${ apartment.deposit}</td>
						<c:if test="${apartment.vacancy eq 'YES'}">
							<td><a href = 'RequestMapping?apartmentID=${apartment.apartmentID }&userID=${userID }'> Request for appointment </a></td>
						</c:if>
						<td></td>
						<td></td>
					</tr>
				</c:if>
			</c:forEach>	
		</table>		
		
	</c:if>
	
	<c:if test="${username == '' or username == null }">
	 	<p> Please Login to proceed further<p/>
	 </c:if>

	</div>
</div>
</body>
</html>