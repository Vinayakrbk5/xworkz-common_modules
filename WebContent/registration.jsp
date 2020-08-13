<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
input[type=text],[type=email]{
width:20%;
}

input[type=number]{
width:10%;
}

#row{
width:50%;
}
#sel{
width:20%;
}

input[type=file],[type=date]{
width:20%;
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
<h3 style="background: black; color: white; padding: 20px; font-size: 30px">Temple Registration Form</h3>
<h3>${unsuccess}</h3>
	<div>
	<h2>Personal Information</h2>
		<form action="register.do" method="post">
		<div class="form-inline">
			<div class="form-group">
     	 	<label for="name">Name:</label>
     		 <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
   			 </div>

			<div class="form-group" style="margin-left:40%">
     	 	<label for="mobile">Mobile Number:</label>
     		 <input type="text" class="form-control" id="mobile" placeholder="Enter mobile number" name="mobileNumber">
   			 </div>
			</div>
			
			<br>
			<div class="form-group">
     	 	<label for="mobile">Address:</label>
     		 <textarea rows="5" cols="20"  id="row" class="form-control" name="address" placeholder="enter address here"></textarea>
   			 </div>
			
			 <div class="form-inline">
			 <div class="form-group">
     	 	<label for="age">Age:</label>
     		 <input type="number" class="form-control" id="age" placeholder="Enter age" name="age">
   			 </div>
			 
				
				 <div class="form-group" style="margin-left:45%">
     	 	<label for="state">State:</label>
     		 <input type="text" class="form-control" id="state" placeholder="Enter state" name="state">
   			 </div>
				</div>
				<br>
			
			<div class="form-inline">
			 <div class="form-group">
     	 	<label for="email">Email :</label>
     		 <input type="email" class="form-control" id="email" placeholder="Enter email" name="emailId">
   			 </div>
			 

				<div class="form-group" style="margin-left:40%">
     	 	<label for="date">Select Date :</label>
     		 <input type="date" class="form-control" id="date" placeholder="select date" name="date">
   			 </div>
   			 </div>
   			 
			
			<h2>Special Information</h2>
			
			<div class="form-group">
     	 	<label for="number">Enter Number Of People :</label>
     		 <input type="number" class="form-control" id="number" placeholder="enter no of people" name="noOfPeople">
   			 </div>
			
			
			<div class="form-group">
     	 	<label >Select Entrance Type : </label>	
     		 <select name="specialEntry" id="sel" class="form-control">
		<c:forEach var="selist" items="${selist}">
			<option value="${selist.value}">${selist.name}</option>
		</c:forEach>
	</select>
   			 </div>
			
	
	<div class="form-group">
     	 	<label >Select Prasad : </label>
     		 <select name="prasad" id="sel" class="form-control">
		<c:forEach var="prlist" items="${prlist}">
			<option value="${prlist.value}">${prlist.name}</option>
		</c:forEach>
	</select>
   			 </div>
	
		
		<div class="form-group">
     	 	<label >Select ID Type : </label>
     		 <select name="idCardType" id="sel" class="form-control">
		<c:forEach var="idlist" items="${idlist}">
			<option value="${idlist.value}">${idlist.name}</option>
		</c:forEach>
	</select>
   			 </div>

<div class="form-group">
     	 	<label >Select Pooja Type : </label>
     		 <select name="poojaType" id="sel" class="form-control">
		<c:forEach var="ptlist" items="${ptlist}">
			<option value="${ptlist.value}">${ptlist.name}</option>
		</c:forEach>
	</select>
   			 </div>

	
	<div class="form-group">
     	 	<label class="file">upload Files :</label>
     		 <input type="file" class="form-control" id="file" placeholder="choose file" name="file">
   			 </div>

			<div>
				<button type="submit" class="btn btn-success">Submit</button>
				<button type="reset" class="btn btn-danger">Cancel</button>
			</div>
			</form>
		</div>
		</div>
</body>
</html>