<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Your messages</title>
</head>
    <body>
        <header>
            <h1>Your messages</h1>
        </header>
        <table border="1">
            <tr>
                <th> From </th>
                <th> At </th>
                <th> Message </th>
            </tr>

            <c:forEach var="message" items="${messages}">
                <tr>
                    <th>${message.senderLogin}</th>
                    <th>${message.sendingTime}</th>
                    <th>${message.text}</th>
                </tr>
            </c:forEach>
        </table>
        <form method="GET" action="<c:url value = "/ui/"/>">
            <p><button type="submit">Return</button></p>
        </form>
    </body>
</html>