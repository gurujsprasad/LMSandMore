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
<TITLE>View Appointment</TITLE>
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
		<p><a href = 'ManagerHome'> HOME </a> | <a href = 'ViewApartment'> View Apartment </a></p>		
		<h4>Apartment Details</h4>
		 <table>
		<c:forEach items="${ ViewApartment }" var="viewApartment">
			<c:set var="apartmentID" value="${ viewApartment.apartmentID }"> </c:set>
			<tr><td>Apartment Number: </td><td>${viewApartment.apartmentNumber}</td></tr>
			<tr><td>Type: </td>
			<td>
			<c:forEach items="${ apartmentType }" var="aptType">
				<input type = 'radio' name = 'apartmentType' <c:choose><c:when test="${aptType.apartmentType eq viewApartment.apartmentType}"> checked </c:when> <c:otherwise>disabled</c:otherwise></c:choose> /> ${aptType.apartmentType} <br/>
			</c:forEach>				
			</td></tr>
			<tr><td>Facilities: </td><td><textarea id = 'facilities' name = 'facilities' rows = '5' cols = '30' readonly>${ viewApartment.facility}  </textarea></td></tr>
			<tr><td>Maximum People: </td><td><input type='text' name = 'maxPeople' id = 'maxPeople' value = '${viewApartment.maxPeople}' readonly/></td></tr>
			<tr><td>Rent: </td><td><input type='text' name = 'rent' id = 'rent' value = '${viewApartment.rent}' readonly/></td></tr>
			<tr><td>Deposits: </td><td><input type='text' name = 'deposit' id = 'deposit' value = '${ viewApartment.deposit }' readonly/></td></tr> 
		</c:forEach>
			</table>  		
	</c:if> 
	<h4> Applications to this apartment </h4>
	<c:if test="${dateInvalid != null && dateInvalid != ''}">
		<div class="alert alert-danger"><p><c:out value="${dateInvalid}" /> </p></div>
		<c:set var="dateInvalid" scope="session" value="${''}"/>
	</c:if>
	
	<table class="table table-striped">
		<tr>
			<th>Application #</th><th>Applicant Name</th><th>Contact #</th><th># People</th><th>Occupation</th>
			<th>Preferences</th><th>Need From Date</th><th>Appointment Date</th><th>Status</th><th>Reschedule Date</th>
			<th>Ruled out Dates</th><th>Rented Out</th>
		</tr>
		
		<c:forEach items="${viewApplications}" var="aplication">
			
				<tr>
				<td>${ aplication.applicationID}</td>
				<td>${aplication.username }</td>
				<td>${ aplication.phoneNumber}</td>
				<td>${ aplication.noOfPeople}</td>
				<td>${ aplication.occupation}</td>
				<td>${ aplication.preference}</td>
				<td>${ aplication.needFromDate}</td>
				<td>${ aplication.appointmendDate}</td>
				<td><p style = 'color:green'>${aplication.status}</p></td>
				
				<td>
				<c:if test="${aplication.status eq 'DENIED' || aplication.status eq 'REQUESTED'}">
					
					<form action = 'RescheduleApplication' method = 'post'>
						<input type = 'hidden' name = 'applicationID' id = 'applicationID' value ='${aplication.applicationID }'/>
						<input type = 'hidden' name = 'apartmentID' id = 'apartmentID' value ='${apartmentID}' />
						<input type = 'text' name = 'rescheduleDate' id= 'rescheduleDate' />
						<input type = "submit" value = 'Reschedule'/>
					</form>
					
				</c:if>
				
				</td>
				<td>
					<c:forEach items="${aplication.ruledOutDates}" var="ruledOutDat">
						<p style='color: RED'> ${ruledOutDat}
					</c:forEach>
					</p></td>
				<td>
				</p></td>
				<td>
					<c:if test="${aplication.status eq 'ACCEPTED' }">
						<a href = "RentOut?applicationnumber=${aplication.applicationID}&apartmentID=${ apartmentID } ">Rent</a>
					</c:if>	
				</td>
				</tr>
				<c:if test="${aplication.status eq 'RENTED'}">
					<a href = 'FeedBackView?apID=${aplication.applicationID}'><p style='font-weight: bold;color:red;'>CLICK HERE TO READ THE FEED BACK</p></a>
				</c:if>
		
		</c:forEach>	
	</table>
	
	<c:choose>
			 <c:when test="${'USER' eq userType}">
		 	<c:out value="You are not admin, please login as a admin !!!" />
		 </c:when>
		</c:choose>
	</div>
	</div>
</body>
</html>