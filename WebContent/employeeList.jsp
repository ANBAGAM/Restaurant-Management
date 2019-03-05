<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>

<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
</head>
<body>

<h4 class="text-success" align="center" > Employee List</h4><br>
<form >
<table  class="table table-hover" style="width:80%" align="center">
		<thead>
		<tr  class="table-primary">
			<th>Employee Id</th>
			<th>Name</th>
			<th>Designation</th>
			<th>Gender</th>
            <th>Date Of Birth</th>
            
		</tr>
		</thead>
	
	<c:forEach var="emplist" items="${EMPLOYEE}">
	<tr  class="table-success" >
		<td>${emplist.id}</td>
		<td>${emplist.name}</td>
		<td>${emplist.designation}</td>
		<td>${emplist.gender}</td>
		<td>${emplist.dateOfBirth}</td>
		
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</form>


</body>
</html>