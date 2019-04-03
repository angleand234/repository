<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<h1>Spittle</h1>
	<a href="<c:url value="/home"></c:url>">Back</a>
	<sf:form method="POST" commandName="spittle" enctype="multipart/form-data" action="/spittles">
		<sf:errors path="*" element="div" cssClass="errors"></sf:errors>
		<sf:label path="message" cssErrorClass="error">Message</sf:label>:
			<sf:input path="message" cssErrorClass="error"/>
		<input type="submit" value="new" />
	</sf:form>
	
</body>
</html>