<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
   
 <h2> Registration Form</h2>
 
 <form action="register" method="post">
 <label>FirstName:</label>
 <input type="text" name="firstName"><br><br>
 <label>LastName:</label>
 <input type="text" name="lastName"><br><br>
  <label>Address:</label>
 <input type="text" name="address"><br><br>
 <label>Contact no.</label>
 <input type="text" name="contactNo"><br><br>
 <label>Password:</label>
 <input type="password" name="password"><br><br>
  <label>Email:</label>
 <input type="email" name="email"><br><br>
 <input type="submit" value="Register">
 
 </form>
</body>
</html>