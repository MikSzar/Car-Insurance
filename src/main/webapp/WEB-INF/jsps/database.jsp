<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Admin</title>
	<style><%@include file="/WEB-INF/css/finalStyle.css"%></style>
</head>
<body>

	<div
		style="padding-top: 10px; padding-bottom: 10px; height: 160px; background: #133486;">
		<img src="/images/logo.png" width="240" height="230"
			style="margin-left: 10px" />
		<div
			style="float: right; padding: 0px; margin-right: 30px; font-size: 20px;">
			<h3 align="right">Hi ${loguser.username}, see what's going on in the car world</h3>
			<div align="right" style="padding-top: -10px;">
					<a href="/" class="myButton">Logout</a>
			</div>
			<br />
		</div>
	</div>

	<br />
<div>
	<div style="padding-left: 50px; margin-right: 16px; font-size: 18px;">
	<h3>Filter Car insurance by:</h3>
		<form action="/listCarInsurance/filtered/name" method="post">
			<label>Car Name:</label><br /> <input type="text"
											  name="name" /><br /> <br /> <input class="button" type="submit" value="Filter" />
		</form>
		<br />
		<form action="/listCarInsurance/filtered/registrationNumber" method="post">
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
				<td>
					<form action="/deleteCarInsurance" method="post">
						<input type="hidden" value="${insurance.id}" name="id" /> <input
							class="button" type="submit" value="Delete" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
<div style="padding-right: 50px; margin-right: 16px; font-size: 24px;">
	<h3 align="center">Show insurance from database:</h3>
	<table align="width:100%">
		<thead>
		<tr>
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
				<td>
					<form action="/deleteCarInsurance" method="post">
						<input type="hidden" value="${insurance.id}" name="id" /> <input
							class="button" type="submit" value="Delete" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
</div>
	<br />
</div>
	<div class="footer">
		<h3 align="center">Share your car insurance with us via e-mail: cartiko@ln.com</h3>
	</div>
</body>
</html>