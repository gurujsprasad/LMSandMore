<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add User</title>
</head>
<body>
<c:if test="${addEmtpy != '' && addEmtpy != null}">
	<p style = 'color:red'>${ addEmtpy} </p>
		<c:set var="addEmtpy"  scope="session"  value=""></c:set>
</c:if>
	<form action = "AddUser" method = "post">
		New User : <input type="text" name = "username" id ="username"/>
		<input type="submit" value = "ADD User"/>
	</form>
</body>
</html>