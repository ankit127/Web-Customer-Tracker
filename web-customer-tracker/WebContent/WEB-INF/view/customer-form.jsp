<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>

<style>
     
              .error {color:GREEN}
     </style>
</head>
<body>
	<form:form action="saveCustomer" modelAttribute="customer" method="POST" >
       <!-- neeed to associate the id -->
       <form:hidden path="id" />
               
    <H2><b>Add New Customer</b></H2> 
	<br />
	<hr />
     <i>Fill Out the form. Asterik (*) means required.</i>    
	<table>
		<tbody>
			<tr>
				<td><label>First Name(*):</label></td>
				<td><form:input path="firstName"/></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label>Last Name(*):</label></td>
				<td><form:input path="lastName"/></td>
			    <td><form:errors path="lastName" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label>Email(*):</label></td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>


            <tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save" /></td>
			</tr>
              

		</tbody>
	</table>
	</form:form>
	<hr />
	<br/>
	<div style="clear; Both;"></div>
	<p>
	    <a href="${pageContext.request.contextPath}/customer/list"><u>Back To List</u></a>
	</p>
</body>
</html>
