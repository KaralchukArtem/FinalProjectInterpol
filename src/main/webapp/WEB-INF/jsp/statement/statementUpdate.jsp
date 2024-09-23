<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Обновление заявки</title>
</head>
<body>
<div>
    <form:form method="post" action="/statement/update" modelAttribute="statementFormUpdate">
        <h2>Обновление заявки</h2>
        <div>
            <form:input type="text" path="id" placeholder="id"></form:input>
        </div>
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
        <div>
            <form:input type="text" path="approved" placeholder="Approved"></form:input>
        </div>
        <div>
            <form:select path="user_id" class="form-control">
                <form:option value="" label="-- Select User --"/>
                <form:options items="${users}" itemValue="id" itemLabel="login"/>
            </form:select>
            <form:select path="type_id" class="form-control">
                <form:option value="" label="-- Select Type --"/>
                <form:options items="${types}" itemValue="id" itemLabel="name"/>
            </form:select>
            <form:errors path="user_id" cssClass="text-danger"/>
        </div>
        <button type="submit">Обновить</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>
