<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "cs320.hw1.models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register Prospects Residents</title>
</head>
<body>

		
		<h2 align='center'>Lease Management System</h2>
		<%
	//CHECKING FOR VALIDATIONS IN THE Registration Page
	if(request.getSession().getAttribute("registrationInvalid") != null  && request.getSession().getAttribute("registrationInvalid") != "" )
	{
		%>
		<p style='color:RED'><%=request.getSession().getAttribute("registrationInvalid") %> </p>
		<%
		request.getSession().setAttribute("registrationInvalid","");
	}
	
%>
		<table cellspacing='10'><form action='RegisterResident' method='post'>
		<tr><th colspan='2'>Sign Up</th></tr>
		<tr><td>Username</td><td><input type='text' name = 'username' id = 'username'/></td></tr>
		<tr><td>Email ID</td><td><input type='text' name = 'emailID' id = 'emailID'/></td></tr>
		<tr><td>Password : </td><td><input type = 'password' name = 'pwd' id = 'pwd'/></td></tr>
		<tr><td>Confirm Password : </td><td><input type = 'password' name = 'cpwd' id = 'cpwd'/></td></tr>
		<tr><td>Contact # : </td><td><input type = 'text' name = 'mobile' id = 'mobile'/></td></tr>
		<tr><td># People : </td><td><input type = 'text' name = 'people' id = 'people'/></td></tr>
		
		<tr><td>Occupation</td><td><input type = 'radio' name = 'occupation' id ='occupation' value = 'Student' checked>Student <br/>
		<input type = 'radio' name = 'occupation' id ='occupation' value = 'Family'>Family<br/>
		<input type = 'radio' name = 'occupation' id ='occupation' value = 'Business'>Business</td></tr>
		<%-- 
		<tr><td>Type</td><td><input type = 'radio' name = 'apartmentType' id ='apartmentType' value = '<%=ApartmentType.OneBHK %>' checked>1 BHK <br/>
		<input type = 'radio' name = 'apartmentType' id ='apartmentType' value = '<%= ApartmentType.TwoBHKOneBath%>'>2 BHK One Bath<br/>
		<input type = 'radio' name = 'apartmentType' id ='apartmentType' value = '<%=ApartmentType.TwoBHKTwoBath %>'>2 BHK Two Bath</td></tr>
		 --%>
		<tr><td>Preferences</td><td><textarea id = 'preferences' name = 'preferences' rows = '5' cols = '30'> </textarea></td></tr>
		<tr><td>Need from Date</td><td><input type='text' name = 'date' id = 'date'/>(Please enter date in in mm/dd/yyyy hh:mm:ss e.g. 10/07/2015 05:00:00)</td></tr>
		
		<tr><td><input type = 'submit' name = 'Sign Up' value = 'Sign Up'/></td>
		<td><input type = 'reset' name = 'clear' value = 'Clear'/></td></tr>
		</form></table>
		
</body>
</html>