<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Your messages</title>
</head>
    <body>
        <header>
            <h1>Ваши сообщения</h1>
        </header>
        <table border="1">
            <tr>
                <th> От кого </th>
                <th> Когда пришло </th>
                <th> Сообщение </th>
            </tr>
            <c:if test="${messages != null}">
                <c:forEach var="message" items="${messages}">
                    <tr>
                        <th>${message.senderLogin}</th>
                        <th>${message.sendingTime}</th>
                        <th>${message.text}</th>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <form method="GET" action="<c:url value = "/ui/"/>">
            <p><button type="submit">На главную страницу</button></p>
        </form>

        <form method="GET" action="<c:url value = "/api/logOut"/>">
            <button type="submit">Выйти из сессии</button>
        </form>
    </body>
</html>