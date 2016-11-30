<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login Users</title>
</head>
<body style="font-family: sans-serif">
	<%
	//CHECKING FOR VALIDATIONS IN THE LOGIN PAGE
	if(request.getSession().getAttribute("emptyFields") != null  && request.getSession().getAttribute("emptyFields") != "" )
	{
		%>
		<p style='color:RED'><%=request.getSession().getAttribute("emptyFields") %> </p>
		<%
		request.getSession().setAttribute("emptyFields","");
	}
	
%>
<%
	//CHECKING if the user is registered newly
	if(request.getSession().getAttribute("registrationInvalid") != null  && request.getSession().getAttribute("registrationInvalid") != "" )
	{
		%>
		<p style='color:RED'><%=request.getSession().getAttribute("registrationInvalid") %> </p>
		<%
		request.getSession().setAttribute("registrationInvalid","");
	}
	
%>
		<table cellspacing='10'>
		<form action = 'Login' method = 'post'>
		<tr><th align='center' colspan='2'>Lease Management System</th></tr>
		<tr><th align='center' colspan='2'>Login</th></tr>
		
		<tr><td>Email ID :</td><td><input type = 'text' name = 'emailID' id = 'emailID'/></td></tr>
		<tr><td>Password :</td><td><input type = 'password' name = 'pwd' id = 'pwd'/></td></tr>
		<tr><td><input type = 'submit' name = 'Login' value = 'Login'/></td>
		<td><input type = 'reset' name = 'clear' value = 'Clear'/></td></tr>
		</form>
		<tr><td></td><td><a href = 'RegisterResident.jsp'> User Registration </a></td></tr>
		</table>

</body>
</html>