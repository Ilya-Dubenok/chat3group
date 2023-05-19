<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Senders</title>
</head>
    <body>
        <header>
            <h1>Список отправителей</h1>
        </header>

        <p><c:if test="${senders == null}">
            Нет сообщений
        </c:if></p>

        <form method="GET" action="<c:url value = "/ui/get-message"/>">
            <c:if test="${senders != null}">
               <c:forEach var="sender" items="${senders}">
                   <p><button type="submit" name="sender" value="${sender}">
                        ${sender}
                   </button></p>
               </c:forEach>
            </c:if>
        </form><br>

        <form method="GET" action="<c:url value = "/ui/"/>">
            <p><button type="submit">На главную страницу</button></p>
        </form>

        <form method="GET" action="<c:url value = "/api/logOut"/>">
            <button type="submit">Выйти из сессии</button>
        </form>
    </body>
</html>