<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<h1>Register</h1>
	<form method="POST">
		First Name:<input type="text" name="firstName" /><br/>
		Last  Name:<input type="text" name="lastName" /><br/>
		User  Name:<input type="text" name="username" /><br/>
		Password  :<input type="password" name="password" /><br/>
		<input type="submit" value="Register" />
	</form>
</body>
</html> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<h1>Register</h1>
	<sf:form method="POST" commandName="spitter" enctype="multipart/form-data">
		<sf:errors path="*" element="div" cssClass="errors"></sf:errors>
		<sf:label path="firstName" cssErrorClass="error">First Name</sf:label>:
			<sf:input path="firstName" cssErrorClass="error"/><br/>
		<sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>:
			<sf:input path="lastName" cssErrorClass="error"/><br/>
		<sf:label path="username" cssErrorClass="error">User Name</sf:label>:
			<sf:input path="username" cssErrorClass="error"/><br/>
		<sf:label path="password" cssErrorClass="error">Password</sf:label>:
			<sf:input path="password" cssErrorClass="error"/><br/>
		<sf:label path="profilePicture" cssErrorClass="error">Profile Picture</sf:label>:
			<sf:input path="profilePicture" cssErrorClass="error" type="file" /><br/>
		<input type="submit" value="Register" />
	</sf:form>
	
</body>
</html>