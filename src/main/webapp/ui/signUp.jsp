<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Регистрация</title>
</head>
<body>
<header>
    <h1>Регистрация</h1>
</header>
        <p><c:if test="${exceptionMessage != null}">
            <c:out value="${exceptionMessage}"/>
        </c:if><p>

<form action="<c:url value="/api/user"/>" method="POST">
    <label for="login">Логин:</label>
    <input type="text" id="login" name="login" required><br><br>
    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password" required><br><br>
    <label for="checkPassword">Пароль повторно:</label>
    <input type="password" id="checkPassword" name="checkPassword" required><br><br>
    <label for="firstName">Имя:</label>
    <input type="text" id="firstName" name="firstName" required><br><br>
    <label for="firstName">Фамилия:</label>
    <input type="text" id="firstName" name="lastName" required><br><br>
    <label for="surname">Отчество:</label>
    <input type="text" id="surname" name="surname"> Если существует<br><br>
    <label for="dateOfBirth">Дата рождения:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" required><br><br>
    <input type="submit" value="Отправить">
</form>
<form action="<c:url value="/ui"/>" method="GET">
    <input type="submit" value="Вернуться">
</form>
</body>
</html>