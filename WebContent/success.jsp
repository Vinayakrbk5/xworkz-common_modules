<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Register</title>
</head>
<body style="background:skyblue">
	<h1>You have Successfully Registered for Temple Visit</h1>
	<h1> ${success}</h1>
	<h2>Information of Visiting Person is :</h2>
	<table style="margin-left:10%;padding:30px">
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

</body>
</html>