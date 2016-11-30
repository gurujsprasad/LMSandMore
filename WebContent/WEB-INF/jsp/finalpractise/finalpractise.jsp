<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cs320.hw1.models.*" %>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html  lang="en">
<head>
<TITLE>Login Page</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<script src="../bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class = "well">
		<div class="page-header"><h1>Lease Management System    </h1></div>
		<table>
			<form method = 'post' action = 'SampleFormDataProcessing'>
		 	 <tr><td>	Name: </td><td><input type = "text" name = 'name'></input></td></tr>
		     <tr><td>   Hobbies: </td><td><input type = "checkbox" value = 'Cricket' name = 'hobby'>cricket
		    			 <input type = "checkbox" value = 'FootBall' name = 'hobby'>football <br/></td></tr>
		     <tr><td>	About Yourself: </td><td> <textarea name = 'yourself' cols = '20' rows = '5'></textarea></td></tr>
		     <tr><td>  <input type = 'submit' value ='enter'></input></td><td>
		    	<input type = 'reset' value = 'clear'/></td>
		    </tr>
		    </form>
		</table>
    </div>
    </div>
   
</body>
</html>