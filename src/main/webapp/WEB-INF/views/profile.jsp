<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spitter</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<h1>Your Profile</h1>
	<a href="<c:url value="/home"></c:url>">Back</a>
	<c:out value="${spitter.username}"></c:out><br/>
	<c:out value="${spitter.password}"></c:out><br/>
	<c:out value="${spitter.firstName}"></c:out>
		<c:out value="${spitter.lastName}"></c:out>
</body>
</html>