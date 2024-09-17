<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Создание заявки</title>
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="statementForm">
        <h2>Регистрация заявки</h2>
        <div>
            <form:input type="text" path="surname" placeholder="Surname"></form:input>
        </div>
        <div>
            <form:input type="text" path="name" placeholder="Name"></form:input>
        </div>
        <div>
            <form:input type="text" path="gender" placeholder="Gender"></form:input>
        </div>
        <div>
            <form:input type="date" path="date_of_birth" placeholder="Birthday"></form:input>
        </div>
        <div>
            <form:input type="text" path="place_of_birth" placeholder="Place of birth"></form:input>
        </div>
        <div>
            <form:input type="text" path="nationality" placeholder="Nationaloty"></form:input>
        </div>
        <div>
            <form:input type="number" path="height" placeholder="Height"></form:input>
        </div>
        <div>
            <form:input type="number" path="weight" placeholder="Weight"></form:input>
        </div>
        <div>
            <form:input type="text" path="eye_color" placeholder="Eye color"></form:input>
        </div>
        <div>
            <form:input type="text" path="accusation" placeholder="Accusation"></form:input>
        </div>
        <div>
            <form:input type="number" path="reward" placeholder="Reward"></form:input>
        </div>
        <div>
            <form:input type="text" path="physique" placeholder="Physique"></form:input>
        </div>
        <button type="submit">Зарегистрироваться</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>