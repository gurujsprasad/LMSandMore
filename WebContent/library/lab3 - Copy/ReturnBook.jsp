<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Return Books</title>
</head>
<body>
<table cellspacing="10">
<tr><th>ID</th><th>Title</th><th>Borrowed By</th><th>Borrowed Date</th><th>Action</th></tr>
<c:forEach items = '${borrowedBooks}' var = 'b'>
	<tr><td><c:out value="${b.bookID}"/></td>
	<td><c:out value='${b.title}'/></td>
	<td><c:out value='${b.studentName}'/></td>
	<td><c:out value='${b.borrowedDate}'/></td>
	<td><a href = 'ReturnBook?bookID=<c:out value="${b.bookID}"/>&studentName=<c:out value="${b.studentName}"/>'>Return</a></td></tr>
</c:forEach>
</table>
</body>
</html>