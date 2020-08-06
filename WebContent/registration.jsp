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
	color: black;
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
margin-left:5%;
width:20%;
}

span.name{
position:relative;
left:100px;
}

span.mobile{
position:relative;
left:300px;
}

span.area{
position:relative;
left:100px;
top:20px;
}

span.age{
position:relative;
left:300px;
bottom:10px;
}

span.state{
position:relative;
left:100px;
top:40px;
}
span.email{
position:relative;
left:300px;
top:40px;
}

span.date{
position:relative;
left:150px;
top:20px;
}
span.num{
position:relative;
left:100px;
}

span.entry{
position:relative;
left:100px;
}
span.prasad{
position:relative;
left:150px;
}
span.id{
position:relative;
left:140px;
}
span.pooja{
position:relative;
left:120px;
}
label{
position:relative;
left:100px;
}
label.date{
position:relative;
left:100px;
top:25px;
}

span.file{
position:relative;
left:220px;
top:25px;
}
label.id{
position:relative;
left:100px;
top:25px;
}

</style>
</head>
<body>

<h3 style="background: black; color: white; padding: 20px; font-size: 30px">Temple Registration Form</h3>
<h3>${unsuccess}</h3>
	<div>
	<h2>Personal Information</h2>
		<form action="register.do" method="post">
			<span class="name">
			<input type="text" name="name" placeholder="enter name"></span>
			
			<span class="mobile">
			<input type="text" name="mobileNumber" placeholder="enter mobile number"></span><br>
			
			<span class="area">
			<textarea rows="5" cols="50" name="address" placeholder="enter address here"></textarea></span>
			 
			<span class="age">
			<input type="number" name="age" placeholder="enter age"></span><br>
			<span class="state">
			<input type="text" name="state" placeholder="enter state"></span>
			 
			<span class="email">
			<input type="text" name="emailId" placeholder="enter email"></span><br><br><br><br>
			<label class="date">Select Date of Visiting :</label>
			<span class="date"><input type="date" name="date" placeholder="select Date of Visiting"></span><br><br><br>
			<hr>
			
			<h2>Special Information</h2>
			<span class="num"><input type="number" name="noOfPeople"
				placeholder="enter no of people"></span>
			<br>
			
			<label >Select Entrance Type : </label>	
		<span class="entry"><select name="specialEntry" id="sel">
		<c:forEach var="selist" items="${selist}">
			<option value="${selist.value}">${selist.name}</option>
		</c:forEach>
	</select></span>
	<br>
	<label >Select Prasad : </label>
	<span class="prasad"><select name="prasad" id="sel">
		<c:forEach var="prlist" items="${prlist}">
			<option value="${prlist.value}">${prlist.name}</option>
		</c:forEach>
	</select></span>
<br>
   <label >Select ID Type : </label>
	<span class="id"><select name="idCardType" id="sel">
		<c:forEach var="idlist" items="${idlist}">
			<option value="${idlist.value}">${idlist.name}</option>
		</c:forEach>
	</select></span>
<br>
  <label >Select Pooja Type : </label>
	<span class="pooja"><select name="poojaType" id="sel">
		<c:forEach var="ptlist" items="${ptlist}">
			<option value="${ptlist.value}">${ptlist.name}</option>
		</c:forEach>
	</select></span>
	<br>
	<label class="id">upload Files :</label><span class="file"> <input type="file" name="file" value="choose file"></span>

			<div>
				<input type="submit" value="Submit" id="but"> 
				<input type="reset" value="Cancel" id="but">
			</div>
		</form>
		<form action="request.jsp" method="post">
		<input type="submit" value="request details">
		</form>
		</div>
</body>
</html>