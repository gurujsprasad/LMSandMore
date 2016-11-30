<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View Library</title>
</head>
<body>
<h2 align="center"> Library Management</h2>
<a href = 'AddToLibraryDB'>Add Books</a> <!--  | <a href = 'AddToLibrary'>Return A Book</a> -->
<h3 align="left">All books present in the library</h3>

<table cellspacing='10'>
<tr><th>ID</th><th>Title</th><th>Author</th><th>Copies</th><th>Action</th></tr>


<c:forEach items = '${books}' var = 'b'>
<tr>
	<td><c:out value="${b.id}" /></td>
	<td><c:out value="${b.title} " /></td>
	<td><c:out value="${b.author} " /></td>
	<td><c:out value="${b.copies} " /></td>
	<c:if test="${b.copies > 0}">
		<td><a href = "#" />Borrow</a> </td></tr>
	</c:if> 
</tr>
</c:forEach>
</table>
</body>
</html>