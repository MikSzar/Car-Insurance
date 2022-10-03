<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User login</title>
	<style><%@include file="/WEB-INF/css/finalStyle.css"%></style>
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
</head>
<body>
<div style="padding-top: 10px; padding-bottom: 10px; height: 160px; background: #133486;">
	<img src="/images/logo.png" width="240" height="230"
		 style="margin-left: 10px" />
	<div class ="frame" style="float: right; padding-right: 0px; margin-right: 20px">
		<a href="https://www.facebook.com/" class="btn">
			<i class="fab fa-facebook-f" style="color: #3b5998;"></i>
		</a>
		<a href="https://www.twitter.com/" class="btn">
			<i class="fab fa-twitter" style="color: #00acee;"></i>
		</a>
		<a href="https://www.dribble.com/" class="btn">
			<i class="fab fa-dribbble" style="color: #ea4c89;"></i>
		</a>
		<a href="https://www.linkedin.com/" class="btn">
			<i class="fab fa-linkedin-in" style="color:#0e76a8;"></i>
		</a>
		<a href="https://www.getpocket.com/" class="btn">
			<i class="fab fa-get-pocket" style="color:#ee4056;"></i>
		</a>
		<a href="https://www.gmail.com/" class="btn">
			<i class="far fa-envelope"></i>
		</a>
	</div>
</div>
<div align="center">
	<h4>You can login now</h4>
	
	<form action="/login" method="post">
		<label>Username:</label><br /> <input type="text" name="username" /><br />
		<label>Password:</label><br /> <input type="password" name="password" /><br />
		<br /> <input class="button" type="submit" value="Login" /><br />
	</form>
</div>

</body>
</html>