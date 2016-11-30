<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cs320.hw1.models.*" %>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE>Add Meeting</TITLE>
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
		<div class="page-header"><h2>Add Meeting</h2></div>
		
		<form  action = 'AddMeeting' method = 'post'  class="form-horizontal" role="form">
    		<div class="form-group">
    			<label class="control-label col-sm-2" for="email">Day</label>
    			<div class="col-sm-2">
    			<SELECT name = "day">
    				<c:forEach items="${days}" var="day">
    				 	<OPTION value = "${day.dayID }">${day.day }</OPTION>
    				</c:forEach>
    			</SELECT>	
					
				</div>
			</div>
			
			<div class="form-group">
    			<label class="control-label col-sm-2" for="email">Time Slot</label>
    			<div class="col-sm-2">
    			<select name = "timeSlot">
    				<c:forEach items="${timeSlots}" var="timeSlot">
    					<OPTION value = "${timeSlot.timeSlotID }">${timeSlot.timeSlot }</OPTION>
    				</c:forEach>
    				</select>
				</div>
			</div>
			<div class="form-group">
    			<label class="control-label col-sm-2" for="pwd">Meeting Notes</label>
    			<div class="col-sm-2">
    				<input type="text" class="form-control" name = 'notes' id = 'notes' />
    			</div>
 		 	</div>
 		 	<div class="form-group">        
      			<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Add Meeting</button>
					<button type="reset" class="btn btn-default">Clear</button>
				</div>
			</div>
		</form>
		
		 </div>
	</div>
</body>
</html>