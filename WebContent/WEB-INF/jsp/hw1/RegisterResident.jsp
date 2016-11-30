<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE> User Registration</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<script src="../bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
<div  class="container-fluid">
<div class = "well">
		<div class="page-header"><h2>Lease Management System    </h2></div>
			<div class="form-group">        
	      		<div class="col-sm-offset-2 col-sm-15">
					<h3> <span class="label label-info">Prospect Residents Registration</span></h3>
				</div>
			</div>
		<c:if test="${registrationInvalid  != null and registrationInvalid != ''}"  >
			<div class="alert alert-danger">
				<p><c:out value="${registrationInvalid}" /> </p>
			</div>
		</c:if>
		
		<form action='RegisterResident' method='post' class="form-horizontal" role="form">
		
		<div class="form-group">
   			<label class="control-label col-sm-2" for="email">User Name</label>
   			<div class="col-sm-2">
   				<input class="form-control" type='text' name = 'username' id = 'username'/>
   			</div>
    	</div>
		<div class="form-group">
   			<label class="control-label col-sm-2" for="email">Email ID </label>
   			<div class="col-sm-2">
   				<input class="form-control" type='text' name = 'emailID' id = 'emailID'/>
   			</div>
   		</div>
		<div class="form-group">
   			<label class="control-label col-sm-2" for="email">Password </label>
   			<div class="col-sm-2">
   				<input class="form-control" type = 'password' name = 'pwd' id = 'pwd'/>
   			</div>
   		</div>
   		<div class="form-group">
   			<label class="control-label col-sm-2" for="email">Confirm Password </label>
   			<div class="col-sm-2">
   				<input class="form-control" type = 'password' name = 'cpwd' id = 'cpwd'/>
   			</div>
   		</div>
   		<div class="form-group">
   			<label class="control-label col-sm-2" for="email">Contact # </label>
   			<div class="col-sm-2">
   				<input class="form-control" type = 'text' name = 'mobile' id = 'mobile'/>
   			</div>
   		</div>
		<div class="form-group">
   			<label class="control-label col-sm-2" for="email"># People </label>
   			<div class="col-sm-2">
   				<input class="form-control" type = 'text' name = 'people' id = 'people'/>
   			</div>
   		</div>
		<div class="form-group">
   			<label class="control-label col-sm-2" for="email">Occupation   </label>
   			 <c:forEach items="${occupations}" var="occupation">
	   			<label  class="control-label col-sm-1" for="email">
	   				<div class="radio">
	   					<lable><input type = 'radio' name = 'occupation' id ='occupation' value = '${occupation.occupation_value}' checked>${occupation.occupation_value}</input></lable>
					</div>
				</label>
			</c:forEach>	
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
   			<label class="control-label col-sm-2" for="email">Preferences</label>
   			<div class="col-sm-2">
   			<textarea  class="form-control" id = 'preferences' name = 'preferences' rows = '5' cols = '30'> </textarea>
   			</div>
   		</div>
   		<div class="form-group">
   			<label class="control-label col-sm-2" for="email">Need from Date</label>
   			
			<div class="col-sm-2"><input class="form-control" type='text' name = 'date' id = 'date'/>(Please enter date in in mm/dd/yyyy hh:mm:ss e.g. 10/07/2015 05:00:00)
			</div>
			</div>
		<div class="form-group">        
     		<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Register</button>
				<button type="reset" class="btn btn-default">Clear</button>
			</div>
		</div>
		</form>
</div>	
</div>
</body>
</html>