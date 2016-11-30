<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Borrow Book</title>
</head>
<body>

<h2>You are borrowing the book with below details</h2>
<table cellspacing="10" >
<form action = 'Borrow' method = 'post'>
<tr><td>Book ID</td><td><input type = 'text' name = 'bookID' id = 'bookID' value = '<c:out value="${param.bookID}"/>' readonly /></td></tr>
<tr><td>Title</td><td><input type = 'text' name = 'title' id= 'title' value = '<c:out value='${param.title}'/>' readonly /></tr>
<tr><td>Student Name</td><td><input type = 'text' name = 'studentName' id = 'studentName' /></tr>
<tr><td></td><td><input type = 'submit' name = 'borrow' value = 'Borrow Book' /></tr>

</form>
</table>
</body>
</html>