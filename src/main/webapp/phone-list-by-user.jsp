<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone Lists</title>
</head>
<body>
<form method = "post" action = "listNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.listName}</h2></td></tr>
	<tr><td colspan="3">Service Provider: ${currentlist.provider.name}</td></tr>
	<tr><td colspan="3">Service Provider Year Established: ${currentlist.provider.yearEstablished}</td></tr>
	<c:forEach var = "listVal" items = "${currentlist.listOfPhones}">
		<tr><td></td><td colspan="3"> ${listVal.name}, ${listVal.color}, ${listVal.releaseDate}
			</td>
		</tr>
	</c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type = "submit" value = "add" name="doThisToList">
</form>
<a href="addPhonesForListServlet">Create a new list</a><br />
<a href="index.html">Insert a new phone</a>
</body>
</html>