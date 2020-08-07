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
  input[type=email],[type=password]
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
      <li><a href="registration.jsp">register</a></li>
      <li><a href="request.jsp">resend</a></li>
      <li><a href="loginpage.jsp">login</a></li>
    </ul>
  </div>
</nav>

<h2>${wrong }</h2>

<div class="container">
  <form  action="login.do" method="post">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
  </form>
  <br>
  <form action="firsttimelogin.jsp" method="post">
  <button type="submit" class="btn btn-success">first time login</button>
  </form>
  
</div>

</body>
</html>