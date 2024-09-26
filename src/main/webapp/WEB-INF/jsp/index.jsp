<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="${pageContext.request.contextPath}/login">Войти</a></h4>
        <h4><a href="/registration">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="${pageContext.request.contextPath}/logout">Выйти</a></h4>
    </sec:authorize>
    <h4><a href="/news/create">Новости (только пользователь)</a></h4>
    <h4><a href="/news/all">Новости (только пользователь)</a></h4>
    <h4><a href="/statement/create"> Заявки (только пользователь)</a></h4>
    <h4><a href="/statement/all"> Все заявки </a></h4>
    <h4><a href="/admin">Пользователи (только админ)</a></h4>
</div>
</body>
</html>