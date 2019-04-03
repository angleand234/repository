<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spittle</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<h1>Hello World! The First Ever Spittle</h1>
	<div class="spittleView">
        <c:out value="${spittle.message}" />
    </div>
    <div>
    	<span class="spittleTime"><c:out value="${spittle.time}"></c:out></span>
    </div>
	<div>
		<a href="<c:url value="/home"></c:url>">Back</a>
	</div>
</body>
</html>