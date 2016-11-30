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
	<div class="page-header"><h1>Grade Calculator  </h1></div>
	<table></table>
	<c:if test="${emptyFieldError != '' && emptyFieldError != null }">
	<div class="alert alert-danger"><p><c:out value="${emptyFieldError}" /> </p></div>
	 </c:if>
<form action = 'GradeCalculator' method = 'post' class="form-horizontal" role="form">
<h2>HomeWorks and Lab Grades</h2>
Home Work 0 <input type= "text" id = 'homework0' name = 'homework0' />
Home Work 1 <input type= "text" id = 'homework1' name = 'homework1' />
Home Work 2 <input type= "text" id = 'homework2' name = 'homework2' />
Home Work 3 <input type= "text" id = 'homework3' name = 'homework3' />
Home Work 4 <input type= "text" id = 'homework4' name = 'homework4' />

lab 1 <input type= "text" id = 'lab1' name = 'lab1' />
lab 2 <input type= "text" id = 'lab2' name = 'lab2' />
lab 3 <input type= "text" id = 'lab3' name = 'lab3' />
lab 4 <input type= "text" id = 'lab4' name = 'lab4' />
lab 5 <input type= "text" id = 'lab5' name = 'lab5' />
lab 6 <input type= "text" id = 'lab6' name = 'lab6' />

Total Point for Homework<input type = "text" id='totalPoints' name ='totalPoints'/>
Total Point for lab <input type = "text" id='totalLab' name ='totalLab'/>


<h2>Midterm Grades</h2>
Users Total <input type= "text" id = 'midtermUsersTotal' name = 'midtermUsersTotal' />
Total Points for Midterm <input type= "text" id = 'midtermTotal' name = 'midtermTotal' />
<br/>
<h2>Final Exam Grades</h2>
Users Total <input type= "text" id = 'finalUsersTotal' name = 'finalUsersTotal' />
Total Points for Finals <input type= "text" id = 'FinalTotal' name = 'FinalTotal' />

<h2>Attendance</h2>
Attendance Percentage 0 - 5% <input type= "text" id = 'attendance' name = 'attendance' />
<input type = "submit" value = 'Calculate Grade' />

</form>

<c:if test="${total != null and total != ''}">
				<div class="alert alert-success"><p>Total Grade : <c:out value="${total}" /> </p></div>
				
			</c:if>

</div>
</div>
</body>
</html>