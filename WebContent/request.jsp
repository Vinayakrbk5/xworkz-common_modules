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
  input[type="email"]{
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
      <li><a href="#">reset password</a></li>
    </ul>
  </div>
</nav>
<div class="container">
<h2>${success}</h2>
<h2> ${fail}</h2>
<form action="request.do" method="post">

<div class="form-group">
     	 	<label for="email">Enter Email to receive Details: </label>
     		 <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
   			 </div>
<!-- <label for="em">Enter Email to receive Details: </label> -->
<!-- <input type="email" name="email" placeholder="enter email" id="em"> -->
<!-- <div class="bg-success"> -->
<button type="submit" class="btn btn-success">Request</button>
<!-- </div> -->
</form>
</div>
</body>
</html>