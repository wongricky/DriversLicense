<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
	<h1 style="text-align: center;">New License</h1>
	<br/><br/>
	<div class="newLicense">
		<form:form modelAttribute="/new" method="post">
			<!-- Drop down name list -->   	
		    <form:select path="license">
		    	<form:option value="-" label="--Select Name"/>
				<form:options items="${persons}"/>
		    </form:select>
		    <p>
		    	<form:label path="state">Enter State: </form:label>
		    	<form:errors path="state"/>
		    	<form:input path="state"/>
		    </p>
		    <p>
		        <form:label path="expirationDate">Expiration Date: </form:label>
		        <form:errors path="expirationDate"/>
		        <form:input type="date" path="expirationDate"/>
		    </p>
			<input type="submit" value="Create"/>		    
		  </form:form>
		  

			<!-- License state, Expiration date -->
		
		
		
	</div>
</body>
</html>