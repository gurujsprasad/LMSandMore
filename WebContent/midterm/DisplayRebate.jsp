<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cs320.midterm.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>DisplayRebate</title>
</head>
<body>
<h3>Rebate for items</h3>
<c:if test="${ userSelect == '' || userSelect == null }">
	<c:set var="selectValue" value="ME"></c:set>
</c:if>
<c:if test="${ userSelect != '' and userSelect != null }">
	<c:set var="selectValue" value="${userSelect}"></c:set>
</c:if>

<form action = 'DisplayRebate' method = 'post'>
	<select id = 'userSelect' name = 'userSelect'>
		<c:forEach items="${users }" var="user">	
			<option value='<c:out value = "${user.user}"></c:out>'
				<c:if test= "${selectValue == user.user}">
					<c:out value ="selected"></c:out>
				</c:if>
			><c:out value = "${user.user}"></c:out></option>		
		</c:forEach>
	</select>
	<input type = "submit" value = "SELECT"/>
</form>


<a href ='AddUser'>Add User</a>
<table>
	<c:if test="${emptyField != null && emptyField != ''}">
		<p style = 'color:red'>${ emptyField} </p>
		<c:set var="emptyField"  scope="session"  value=""></c:set>
	</c:if>
	<tr><th>Rebate</th><th>Amount</th><th>Received</th></tr>
	<c:forEach items="${items}" var="item">
		<c:if test="${selectValue == item.user}">
		<c:set var="total" value="${ item.amount + total}"></c:set>
			<tr>
				<td><c:out value = "${item.itemName}"></c:out></td>
				<td><c:out value = "${item.amount}"></c:out>$</td>
				<td>
					<c:if test="${item.receivedFlag eq 'true' }">
						
						<fmt:formatDate pattern="MM/dd/yyyy"  value="${item.recievedDate}" />
						
						<c:set var="totalReceived" value="${ item.amount + totalReceived}"></c:set>
					</c:if>
					<c:if test="${item.receivedFlag eq 'false' }">
						<a href = 'ReceiveRebate?itemName=<c:out value = "${item.itemName}"></c:out>&userName=<c:out  value = "${ userSelect}"></c:out>'>Not Received</a>
					</c:if>
					
				</td>
			</tr>	
		</c:if>
	</c:forEach>
	
		<tr>
			<form action = "AddItem" method = "post">
				<td><input type = "text" id = "itemname" name ="itemname"/></td>
				<td><input type = "text" id = "amount" name = "amount"/></td>
				<input type = "hidden" name = "username" id ="username" value = '${ userSelect}'></input>
				<td><input type = "submit" value ="ADD"/></td>
			</form>
		</tr>	
	
</table>
<p>Total:<c:out value="${total }"></c:out>$</p>
<p>Total Received:<c:out value="${totalReceived }"></c:out>$</p>
</body>
</html>