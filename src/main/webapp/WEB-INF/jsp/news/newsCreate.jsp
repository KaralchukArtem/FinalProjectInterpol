<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Новости</title>
</head>
<body>
<div>
    <h2>Новости <br> Только для залогинившихся пользователей.</h2>
    <form:form method="POST" enctype="multipart/form-data" modelAttribute="newsForm">
        <table>
            <tr>
                <td><label>Enter the news headline</label></td>
                <td><form:input type="text" path="title"></form:input></td>
            </tr>
            <tr>
                <td><label>Select a file to upload</label></td>
                <td><form:input type="file" path="imageData"></form:input></td>
            </tr>
            <tr>
                <td><label>Enter the text of the news</label></td>
                <td><form:input type="text" path="text"></form:input></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>