<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<h1>Welcome to Spittr</h1>
	<a href="<c:url value="/spittles"></c:url>">Spittles</a> | 
	<a href="<c:url value="/spitter/register"></c:url>">Register</a>
</body>
</html>