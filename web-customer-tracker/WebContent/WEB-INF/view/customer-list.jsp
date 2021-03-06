<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>


</head>
<body>
         <div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
	
		
		  <input type="button" value= "Add Customer" 
		          onclick="window.location.href='showFormForAdd'; return false;"
		          class = "add-button"
		  />

			<!--  add our html table here -->
		
			<table border="3">
				<tr bgcolor="GREEN">
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				 
				  <c:url var="updateLink" value="/customer/showFormForUpdate">
				          <c:param name="customerId" value="${tempCustomer.id}"/>
				  </c:url>
				  <!-- loop over and print our customers -->
				
				 
				  <c:url var="deleteLink" value="/customer/delete">
				          <c:param name="customerId" value="${tempCustomer.id}"/>
				  </c:url>
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<!-- -add update Link -->
						<td> 
						       <a href="${updateLink}"> Update</a> 
						       |  
						       <a href="${deleteLink}" 
						        onclick="if (!(confirm('Are You Sure You want to delete this?'))) return false"> Delete</a>
					    </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
</body>
</html>
