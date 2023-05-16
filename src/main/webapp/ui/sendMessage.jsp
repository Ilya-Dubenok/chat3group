<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Send Message</title>
</head>
    <body>
        <header>
            <h1>Send Message</h1>
        </header>

        <p><c:if test="${errorMessage != null}">
           <c:out value="${errorMessage}"/>
        </c:if><p>

        <form method="POST" action="<c:url value = "/api/message"/>">
            <label for="recipientLogin">Recipient login:</label>
            <input type="text" id="recipientLogin" name="recipientLogin" required><br><br>
            <label for="messageText">Message text:</label>
            <input type="text" id="messageText" name="messageText" required><br><br>
            <button type="submit">Отправить</button>
        </form>

        <form method="GET" action="<c:url value = "/ui/"/>">
            <button type="submit">На главную страницу</button>
        </form>

        <form method="GET" action="<c:url value = "/api/logOut"/>">
            <button type="submit">Выйти из сессии</button>
        </form>
    </body>
</html>