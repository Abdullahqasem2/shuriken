<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/profile" method="get">
<input type="submit" value="${user.username} Profile"/>
</form>
<form action="/News" method="get">
<input type="submit" value="News"/>
</form>
<form action="/community" method="get">
<input type="submit" value="Community"/>
</form>
<form action="/messages" method="get">
<input type="submit" value="General Chat"/>
</form>
<c:choose>

</c:choose>

</body>
</html>