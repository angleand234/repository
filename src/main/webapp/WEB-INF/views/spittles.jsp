<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spittle</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<h1>Recent Spittles</h1>
	<a href="<c:url value="/home"></c:url>">Back</a>
	<c:forEach items="${spittleList}" var="spittle">
	    <li id="spittle_<c:out value="spittle.id"/>">
	        <div class="spittleMessage">
	            <c:out value="${spittle.message}" />
	        </div>
	        <div>
	            <span class="spittleTime"><c:out value="${spittle.time}" /></span>
	            <span>(<c:out value="${spittle.latitude}"></c:out>,<c:out value="${spittle.longitude}"></c:out>)</span>
	        </div>
	    </li>
	</c:forEach>
</body>
</html>