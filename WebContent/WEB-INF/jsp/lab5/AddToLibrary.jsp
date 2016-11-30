<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add to Library</title>
</head>
<body>
<h2 align="center"> Library Management</h2>
<p> Add the Book details below,</p>
<c:if test="${formError != null && formError != ''}">
		<p style = 'color:red'>${ formError} </p>
		<c:set var="formError"  scope="session"  value=""></c:set>
	</c:if>
<table cellspacing="10">
<form name = 'addBooks' action = 'AddToLibraryDB' method = 'post'>
<tr><td>Title : </td><td><input type = 'text' id = 'title' name = 'title' /></td></tr>
<tr><td>Author: </td><td><input type = 'text' id = 'Author' name = 'Author' /></td></tr>
<tr><td>Copies: </td><td><input type = 'text' id = 'copies' name = 'copies' />Enter integer value</td></tr>
<tr><td><input type = 'submit' name = 'Add' value = 'Add'/></td>
<td><input type = 'reset' name = 'clear' value = 'Clear'/></td></tr>
</form>
</table>
</body>
</html>