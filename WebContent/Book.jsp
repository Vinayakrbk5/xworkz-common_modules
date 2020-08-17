<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h2> Welcome  ${email}</h2>
<div class="container">
<form action="book.do" method="post">

<div class="form-group">
      <input type="text" class="form-control" value="${email}" name="email" readonly="readonly">
    </div>
<div class="form-inline">
			<div class="form-group">
     	 	<label for="date">Select Date:</label>
     		 <input type="date" class="form-control" id="date" placeholder="select date" name="date">
   			 </div>

			<div class="form-group" style="margin-left:40%">
     	 	<label for="num">Enter NoOfPeople</label>
     		 <input type="number" class="form-control" id="num" placeholder="enter no of people" name="noOfPeople">
   			 </div>
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
			
			
			<div>
				<button type="submit" class="btn btn-success">Book</button>
				<button type="reset" class="btn btn-danger">Cancel</button>
			</div>

</form>
</div>
</body>
</html>