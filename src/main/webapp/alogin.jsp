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
	<h2 style="text-align: center">Admin Login</h2>
	<form action="adminLogin" method="POST" class="form-admin">
		<input type="text" placeholder="User Name" name="uname"> 
		<input type="password" placeholder="Password" name="pwd"> 
		<button type="submit" class="add-btn">Login</button>
	</form>
</body>
</html>