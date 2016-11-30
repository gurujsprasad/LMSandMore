<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cs320.hw1.models.*" %>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE>Edit Meeting</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<script src="../bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class = "well">
		<div class="page-header"><h1>Meeting Calendar</h1></div>
		<div class="page-header"><h2>Edit Meeting</h2></div>
		<table class="table table-striped">
			<c:forEach items="${meeting }" var="meeting">
				<tr><th>Day:</th><td><c:out value="${meeting.day}"></c:out></td></tr>
				<tr><th>Time Slot:</th><td><c:out value="${meeting.timeSlot}"></c:out></td></tr>
				<form action = "EditMeeting" method = "post">
				<input type = 'hidden' name = 'meetingID' value = "${meeting.meetingID}" />
					<tr><th>Meeting Notes: </th><td> <input type = "text" name = "notes" value = "${meeting.notes }"/></td></tr>
					<tr><td></td><td><input type = "submit" value = "DELETE" name = "button"/><input type = "submit" value = "SAVE"  name = "button"/></td></tr>
				</form>
			</c:forEach>
		</table>
		
		 </div>
	</div>
</body>
</html>