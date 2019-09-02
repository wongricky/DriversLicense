<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>
	<h1 style="text-align: center;">New Person</h1>
	<br/><br/>
	<div class="form" style="margin: 0 auto; width: 250px;">
		<form:form method="post" modelAttribute="person">
			<p>
				<form:label path="firstName">First Name</form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</p>
			<p>
				<form:label path="lastName">Last Name</form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
			</p>
			<input type="submit" value="Create!"/>
		</form:form>
	</div>
	
	<!--  Testing show persons --> 
	<div class="show">
	<h1>People Created:</h1>
	<table>
		<c:forEach items="${persons}" var="person">
		<tr>
			<td>${person.firstName}</td>
			<td>${person.lastName}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>