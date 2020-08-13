<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
    </ul>
  </div>
</nav>

<h3>${password }</h3>
<h3>${wrong }</h3>

<div class="container">
  <form class="form-inline" action="generate.do" method="post">
    <div class="form-group">
      <label for="email">Enter Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <button type="submit" class="btn btn-success">generate password</button>
  </form>
</div>

</body>
</html>