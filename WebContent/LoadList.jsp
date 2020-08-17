<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  input[type=text]
  {
  width:20%;
  }
  input[type=submit]
  {
  width:30%;
  }
  </style>
</head>
<body class="bg-success">



<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">XWorkz</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="Registration.jsp">register</a></li>
      <li><a href="Request.jsp">resend</a></li>
      <li><a href="LoginPage.jsp">login</a></li>
      <li><a href="FirstTimeLogin.jsp">first time login</a></li>
      <li><a href="ResetPassword.jsp">reset password</a></li>
      <li>Welcome, ${email}</li>
    </ul>
  </div>
</nav>

<h2> Welcome to Kashi Vishwanath Temple</h2>

<form action="onBooking.do" method="post">
<div class="form-group">
     WelCome  <input type="text" class="form-control" value="${email}" name="email" readonly="readonly">
    </div>
<button type="submit" class="btn btn-success">Book</button>
</form>
<br>
<form action="" method="post">
<button type="submit" class="btn btn-danger">Search</button>
</form>

</body>
</html>