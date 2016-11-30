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
			<p class="text-left">
				<a href = 'AddApartment'> Add Apartment </a></p>
			<p class="text-left">
				<a href = 'ViewApartment'> View Appartment </a>	
			</p>
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