<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Заявка</title>
</head>
<body>
<div>
    <p>Surname: <c:out value="${statement.id}"></c:out></p>
    <p>Name :<c:out value="${statement.name}"></c:out></p>
    <p>Surname: <c:out value="${statement.surname}"></c:out></p>
    <p>Age: <c:out value="${statement.date_of_birth}"></c:out></p>
    <p>Nationality: <c:out value="${statement.nationality}"></c:out></p>
    <br>
    <a href="/">Главная</a>
</div>
</body>
</html>