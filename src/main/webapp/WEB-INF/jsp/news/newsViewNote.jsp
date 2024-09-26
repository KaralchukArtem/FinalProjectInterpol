<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Создание заявки</title>
</head>
<body>
<div>
    <p>id: <c:out value="${news.id}"></c:out></p>
    <p>Title :<c:out value="${news.title}"></c:out></p>
    <img content="${pageContext.request.contextPath}/static/images/les.jpg>" alt="Xyusss"/>
    <p>Text: <c:out value="${news.text}"></c:out></p>
    <p>Year: <c:out value="${news.year}"></c:out></p>
    <br>
    <a href="/">Главная</a>
</div>
</body>
</html>