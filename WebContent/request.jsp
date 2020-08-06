<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
button[type=submit]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
<div class="jumbotron">
<h2>${success}</h2>
<h2> ${fail}</h2>
<form action="request.do" method="post">
<label for="em">Enter Email to receive Details: </label>
<input type="email" name="email" placeholder="enter email" id="em">
<div class="bg-success">
<button type="submit">Request</button>
</div>
</form>
</div>
</body>
</html>