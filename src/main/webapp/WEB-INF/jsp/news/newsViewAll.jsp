<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form:form method="get" action="/news/get">
        <c:forEach var="news" items="${newsDTOS}">
            <p>Title:
                <button type="submit" name="id" value="${news.id}">
                    <c:out value="${news.title}"></c:out>
                </button>
            </p>
            <p>Text :<c:out value="${news.text}"></c:out></p>
            <img content="${pageContext.request.contextPath}/static/images/les.jpg>" alt="Xyusss"/>
            <p>Nationality: <c:out value="${news.year}"></c:out></p>
            <br>
        </c:forEach>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>
