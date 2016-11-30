<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE>AddApartment</TITLE>
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

		
		
		<c:if test="${registrationFormDetailInvalid != null and registrationFormDetailInvalid != ''}">
			<div class="alert alert-danger"><p><c:out value="${registrationFormDetailInvalid}" /> </p></div>
			<c:set var="registrationFormDetailInvalid" scope="session" value="${''}"/>
		</c:if>
		
		<c:if test="${username != null && username != '' && 'ADMIN' eq userType }">
			<h4>Add Apartment Details </h4>
			<p><a href = 'ManagerHome'> HOME </a> | <a href = 'Logout'> Signout </a></p>
			<form action='AddApartment' method='post' class="form-horizontal" role="form">
			
			<div class="form-group">
    			<label class="control-label col-sm-2" for="email">Apartment #</label>
    			<div class="col-sm-2">
					<input type='text' name = 'aptnumber' id = 'aptnumber' class="form-control"/>
				</div>
			</div>
  			<div class="form-group">
	   			<label class="control-label col-sm-2" for="email">Type</label>
	   			 <c:forEach items="${apartments}" var="apartment">
		   			<label   class="control-label col-sm-1" for="email">
		   				<div class="radio">
		   						<label style = 'font: bold;'><input type = 'radio' name = 'apartmentType' id ='apartmentType' value = '${apartment.apartmentType}' checked>${apartment.apartmentType}</label>
						</div>
					</label>
				</c:forEach>
			</div>
   				
			
			<div class="form-group">
	   			<label class="control-label col-sm-2" for="email">Facilities </label>
	   			<div class="col-sm-2">
	   				<textarea id = 'facilities' class="form-control" name = 'facilities' rows = '5' cols = '30'> </textarea>
	   			</div>
   			</div>
			
			<div class="form-group">
	   			<label class="control-label col-sm-2" for="email">Maximum People </label>
	   			<div class="col-sm-2">
	   				<input class="form-control" type='text' name = 'maxPeople' id = 'maxPeople'/>
	   			</div>
   			</div>
   		
   			
   			
   			<div class="form-group">
	   			<label class="control-label col-sm-2" for="email">Rent </label>
	   			<div class="col-sm-2">
	   				<input class="form-control" type='text' name = 'rent' id = 'rent'/>
	   			</div>
   			</div>	
			
			<div class="form-group">
	   			<label class="control-label col-sm-2" for="email">Deposit </label>
	   			<div class="col-sm-2">
	   				<input class="form-control" type='text' name = 'deposit' id = 'deposit'/>
	   			</div>
   			</div>	
			
			<div class="form-group">        
     		<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Register</button>
				<button type="reset" class="btn btn-default">Clear</button>
			</div>
		</div>
			
			
		
	</form>
		
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