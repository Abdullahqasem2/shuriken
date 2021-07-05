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

<form action="/avatar" method="post">
<c:forEach items="${images}" var="image"></c:forEach>
<input type="checkbox" name="image" value="${image}"/><img alt="Avatar" src="${image}"/>
<input type="submit" value="Submit">
</form>

</body>
</html>