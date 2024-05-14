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

	<h2 style="text-align: center">Add Event</h2>
	<form action="addEvent" method="POST" class="form-admin" enctype="multipart/form-data" >
		<input type="text" placeholder="Title" name="title" required> <input
			type="text" placeholder="Location" name="location" required> <input
			type="text" placeholder="Ratings" name="ratings" required> <input
			type="number" placeholder="Review count" name="reviewCount" required>
		<input type="number" placeholder="Open spots" name="openSpots" required>
		<input type="number" placeholder="Price" name="price" required>
		<!-- <input type="text" name="coverImage" hidden="true" value="mountain-bike.png">-->
		 <input type="file" name="coverImage" accept="image/*" required>
		<button type="submit" class="add-btn">Add</button>
	</form>

	<h2 style="text-align: center">Update or Delete Event</h2>
	<table id="update-delete"></table>

	<script src="./scripts/admin.js"></script>
</body>
</html>