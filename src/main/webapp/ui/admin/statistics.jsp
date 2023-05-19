<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>LogUp</title>
</head>
<body>
<header>
    <h1>Statistics</h1>
</header>

Активных пользователей: <c:out value="${activeUsers}"/><br>
Отправлено сообщений: <c:out value="${messages}" /><br>
Всего зарегистрировано пользователей: <c:out value="${registeredUsers}" /><br>


</body>
</html>