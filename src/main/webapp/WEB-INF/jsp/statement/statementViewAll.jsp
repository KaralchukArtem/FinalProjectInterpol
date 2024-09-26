<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Создание заявки</title>
</head>
<body>
<div>
    <sec:authorize access="hasRole('USER')">
        <form:form method="get" action="/statement/get">
            <c:forEach var="statement" items="${statements}">
                <p>Name:
                    <button type="submit" name="id" value="${statement.id}">
                        <c:out value="${statement.name}"></c:out>
                    </button>
                </p>
                <p>ID :<c:out value="${statement.id}"></c:out></p>
                <p>Name: <c:out value="${statement.name}"></c:out></p>
                <p>Surname: <c:out value="${statement.surname}"></c:out></p>
                <p>Age: <c:out value="${statement.date_of_birth}"></c:out></p>
                <p>Nationality: <c:out value="${statement.nationality}"></c:out></p>
                <br>
            </c:forEach>
        </form:form>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <form:form method="get" action="/statement/update">
            <c:forEach var="statement" items="${statements}">
                <p>Name:
                    <button type="submit" name="id" value="${statement.id}">
                        <c:out value="${statement.name}"></c:out>
                    </button>
                </p>
                <p>ID :<c:out value="${statement.id}"></c:out></p>
                <p>Name: <c:out value="${statement.name}"></c:out></p>
                <p>Surname: <c:out value="${statement.surname}"></c:out></p>
                <p>Age: <c:out value="${statement.date_of_birth}"></c:out></p>
                <p>Nationality: <c:out value="${statement.nationality}"></c:out></p>
                <br>
            </c:forEach>
        </form:form>
    </sec:authorize>
    <a href="/">Главная</a>
</div>
</body>
</html>