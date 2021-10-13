<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Name: <input type = "text" name = "name" value= "${itemToEdit.name}">
Color: <input type = "text" name = "color" value= "${itemToEdit.color}">
Release Date: <input type = "text" name = "releaseDate" value= "${itemToEdit.releaseDate}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>