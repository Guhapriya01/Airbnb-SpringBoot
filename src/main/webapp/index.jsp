<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Airbnb - Home</title>
	
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	<link rel="stylesheet" href="./styles/main.css"/>
	
</head>
<body>
	<%@include file="./components/NavBar.jsp"%>
	<%@include file="./components/Signup.jsp" %>
	
	<div class="search-bar">
		<form action="search" id="s-form">
			<input type="text" placeholder="Location" name="location">
			<input type="number" placeholder="Price" name="price">
			<input type="number" placeholder="Review Count" name="reviewCount">
			<button type="submit" class="search-btn">Search</button>
		</form>
		<button class="clear-btn" onclick="clearSearch()">Clear</button>
	</div>
	
	<div id="events" class="cards-container"></div>
	
	<script src="./scripts/index.js"></script>
	
</body>
</html>