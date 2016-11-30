<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cs320.hw1.models.*" %>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE>Meeting Calendar</TITLE>
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
		<p><a href = 'AddTimeSlot'> AddTimeSlot </a> | <a href = 'AddMeeting'> AddMeeting </a></p>
		<table class="table table-striped">
		
		<tr>
		<th></th>
		<c:forEach items="${days}" var="day">
			<th><c:out value="${day.day}"></c:out></th>
		</c:forEach>
		</tr>
		
		<c:forEach items="${timeSlots}" var="timeSlot1">
			<tr>
				<th><c:out value="${timeSlot1.timeSlot}"></c:out></th>
				<c:forEach items="${days}" var="day1">
					<td>
					
					<c:forEach items="${meetings}" var="meeting">
				 		<c:if test="${ meeting.dayID ==  day1.dayID && meeting.timeSlotID ==  timeSlot1.timeSlotID}">
				 			
				 			<c:out value="${meeting.notes}"></c:out><a href = "EditMeeting?meetingID=${ meeting.meetingID }">[EDIT]</a>
				 		</c:if>
					</c:forEach>
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
		</table>
		
		 </div>
	</div>
</body>
</html>