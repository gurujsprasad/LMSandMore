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
		
		<!-- *********************** this is for the form  ******************************** -->
 			
 			<form  action = 'Login' method = 'post'  class="form-horizontal" role="form">
    		<div class="form-group">
    			<label class="control-label col-sm-2" for="email">Put the name here <span class="glyphicon glyphicon-envelope"></span></label>
    			<div class="col-sm-2">
					<input type = 'text'  class="form-control" name = 'emailID' id = 'emailID'/>
				</div>
			</div>
			<div class="form-group">
    			<label class="control-label col-sm-2" for="pwd">Name</label>
    			<div class="col-sm-2">
    				<input type="password" class="form-control" name = 'pwd' id = 'pwd' />
    			</div>
 		 	</div>
 		 	<div class="form-group">        
      			<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</div>
			</div>
		</form>
		 </div>
	</div>
</body>
</html>