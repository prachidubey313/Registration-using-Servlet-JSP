<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Confirmation</title>
</head>
<body>
      <h2>Registration Confirmation </h2>
      <p> ${message}<p>
      <%
      String email = (String) session.getAttribute("email_key");
      System.out.println(email);
      %>
      <h3> Email :<%=email %> </h3> 
      <% 
      String myname = (String) session.getAttribute("name_key");

      %>
     <h3> Name :<%=myname  %> </h3> 
     
 
</body>
</html>