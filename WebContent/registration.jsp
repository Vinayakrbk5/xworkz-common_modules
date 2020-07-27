<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration-Form</title>
<style>
input[type=text], select {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 6px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}


input[type=reset] {
	width: 100%;
	background-color: rgba(255, 0, 0, 0.7);
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=number] {
	width: 10%;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 50px;
}

#but {
	width: 15%;
}

#sel{
margin-left:10%;
width:20%;
}

</style>
</head>
<body>

<h3 style="background: black; color: white; padding: 20px; font-size: 30px">Temple Registration Form</h3>

	<div>
	<h2>Personal Information</h2>
		<form action="register.do" method="post">

			<input type="text" name="name" placeholder="enter name">
			<input type="text" name="mobileNumber" placeholder="enter mobile number"><br>
			<textarea rows="5" cols="50" name="address" placeholder="enter address here"></textarea>
			<br> 
			<input type="number" name="age" placeholder="enter age">
			<input type="text" name="state" placeholder="enter state">
			 
			<input type="text" name="emailId" placeholder="enter email">
			<hr>
			
			<h2>Special Information</h2>
			<input type="date" name="date" placeholder="select Date of Visiting">
			<input type="number" name="noOfPeople"
				placeholder="enter no of people for Visiting">
			<br>
			<label >Select Entrance Type : </label>
				
		<select name="SE" id="sel">
		<c:forEach var="selist" items="${selist}">
			<option value="${selist.value}">${selist.value}</option>
		</c:forEach>
	</select>
	<br>
	<label >Select Prasad : </label>
	<select name="PR" id="sel">
		<c:forEach var="prlist" items="${prlist}">
			<option value="${prlist.value}">${prlist.value}</option>
		</c:forEach>
	</select>
<br>
<label >Select ID Type : </label>
	<select name="ID" id="sel">
		<c:forEach var="idlist" items="${idlist}">
			<option value="${idlist.value}">${idlist.value}</option>
		</c:forEach>
	</select>
<br>
<label >Select Pooja Type : </label>
	<select name="PT" id="sel">
		<c:forEach var="ptlist" items="${ptlist}">
			<option value="${ptlist.value}">${ptlist.value}</option>
		</c:forEach>
	</select>

			<div>
				<input type="submit" value="Submit" id="but"> 
				<input type="reset" value="Cancel" id="but">
			</div>
		</form>
		</div>
</body>
</html>