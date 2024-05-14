<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airbnb - Admin</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet" href="./styles/main.css" />
</head>
<body>

	<% 
 	 if(session.getAttribute("admin")==null){
		  response.sendRedirect("index.jsp");
 	 }
	%>
	
	<nav class="navbar">

		<a href="#" class="navbar-logo"><img src="./images/airbnb.png"
			alt="airbnb-logo" /></a>

		<div class="navbar-options">
			<p>Airbnb Admin Panel</p>
			<a href="#" class="navbar-icon"> <i class="fa fa-globe"
				aria-hidden="true"></i>
			</a>
			<div class="navbar-user">
				<div class="navbar-icon" id="admin"><i class="fa-solid fa-circle-user"></i></div>
			</div>
		</div>
	</nav>
	
	<div class="signup" id="sign" style="visibility:hidden">
		<a href="/alogout">Logout</a>
	</div>
	
	<h2 style="text-align: center">Update Event</h2>
	<form action="updateEvent" method="POST" class="form-admin">
		<input type="text" hidden="true" name="id" value="${data.getId()}"> 
		<input type="text" placeholder="Title" name="title" value="${data.getTitle()}"> 
		<input type="text" placeholder="Location" name="location" value="${data.getLocation()}"> 
		<input type="text" placeholder="Ratings" name="ratings" value="${data.getRatings()}">
		<input type="number" placeholder="Review count" name="reviewCount" value="${data.getReviewCount()}">
		<input type="number" placeholder="Open spots" name="openSpots" value="${data.getOpenSpots()}">
		<input type="number" placeholder="Price" name="price" value="${data.getPrice()}">
		<button type="submit" class="update-btn">Update</button>
	</form>
</body>
</html>