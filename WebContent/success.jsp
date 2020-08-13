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
  tr{
  width:50%;
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
    </ul>
  </div>
</nav>

<div class="container">
	<h3>You have Successfully Registered for Temple Visit</h3>
	<h3> ${success}</h3>
	<h3>Information of Visiting Person is :</h3>
	<table class="table table-striped">
		<tbody>
			<tr>
				<td>Person Name</td>
				<td>:<b>${dto.name}</b></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td>:<b>${dto.mobileNumber}</b></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>:<b> ${dto.address}</b></td>
			</tr>
			<tr>
				<td>Age</td>
				<td>:<b>${dto.age}</b></td>
			</tr>
			<tr>
				<td>State</td>
				<td>:<b> ${dto.state}</b></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td>:<b>${dto.emailId}</b></td>
			</tr>
			<tr>
				<td>Date Of Visiting</td>
				<td>: <b>${dto.date}</b></td>
			</tr>
			<tr>
				<td>No Of People Visiting</td>
				<td>:<b>${dto.noOfPeople}</b></td>
			</tr>
			<tr>
				<td>Special Entry Type</td>
				<td>:<b>${ dto.specialEntry}</b></td>
			</tr>
			<tr>
				<td>Prasad Type</td>
				<td>:<b>${ dto.prasad}</b></td>
			</tr>
			<tr>
				<td>Identity CardType</td>
				<td>:<b>${ dto.idCardType}</b></td>
			</tr>
			<tr>
				<td>Pooja Type</td>
				<td>:<b>${ dto.poojaType}</b></td>
			</tr>

		</tbody>
	</table>
</div>
</body>
</html>