<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Cartiko.com</title>
	<style><%@include file="/WEB-INF/css/finalStyle.css"%></style>
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
</head>
<body>

	<div
		style="padding-top: 10px; padding-bottom: 10px; height: 160px; background: #133486;">
		<img src="/images/logo.png" width="240" height="230"
			style="margin-left: 10px" />
		<div class ="frame" style="float: right; padding-right: 50px; margin-right: 20px">
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

		<div
			style="float: right; padding-right: 50px; border-bottom: rgba(112,164,232,0.77); margin-right: 16px; font-size: 18px;">

			<h3>Go to Login/Registration:</h3>
			<table align="right">
				<thead>
				<tr>
					<th></th>
					<span><a onclick="location.href ='/registration'"></a></span>
					<th></th>
					<span><b onclick="location.href ='/login'"></b></span>
			</table>

		</div>
	</div>

	<br />

<div>
	<div style="padding-left: 50px; margin-left: 16px; font-size: 18px;">
		<h3>Filter Car insurance by:</h3>
		<form action="/filtered/name" method="post">
			<label>Car name:</label><br /> <input type="text"
											  name="name" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
		<br />
		<form action="/filtered/registrationNumber" method="post">
			<label>Registration Number:</label><br /> <input type="text"
												 name="registrationNumber" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>

		<table style="width:100%">
			<c:forEach items="${filteredInsurance}" var="insurance">
				<tr>
					<td><img src="${insurance.imageurl}" width="300" height="180"/></td>
					<td align="center">${insurance.name}</td>
					<td align="center">${insurance.value}</td>
					<td align="center">${insurance.damageAssessment}</td>
					<td align="center">${insurance.damageDate}</td>
					<td align="center">${insurance.insuranceDate}</td>
					<td align="center">${insurance.registrationNumber}</td>
					<td><button class="button" onclick="location.href ='/details/${insurance.id}'" >Check insurance</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>

<div style="padding-right: 50px; margin-right: 16px; font-size: 24px;">
	<h3 align="center">Latest Car Insurances:</h3>
	
	<table style="width:100%">
		<thead>
			<tr>
				<th></th>
				<th>Name</th>
				<th>Car Value</th>
				<th>Damage Assessment</th>
				<th>Damage Date</th>
				<th>Insurance Date</th>
				<th>Registration Number</th>
			</tr>
		</thead>
		<c:forEach items="${insurance}" var="insurance">
			<tr>
				<td><img src="${insurance.imageurl}" width="300" height="180"></td>
				<td align="center">${insurance.name}</td>
				<td align="center">${insurance.value}</td>
				<td align="center">${insurance.damageAssessment}</td>
				<td align="center">${insurance.damageDate}</td>
				<td align="center">${insurance.insuranceDate}</td>
				<td align="center">${insurance.registrationNumber}</td>
				<td><button class="button" onclick="location.href ='/details/${insurance.id}'" >Check insurance</button></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	</div>
	<br />
</div>
</div>
<div class="footer">
	<h3 align="center">Share your car insurance with us via e-mail: cartiko@ln.com</h3>
</div>
</body>
</html>