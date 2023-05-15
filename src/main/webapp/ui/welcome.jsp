<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>LogUp</title>
</head>
<body>
<header>
    <h1>Welcome page</h1>
</header>


<c:choose>
    <c:when test="${empty user}">
        <form action="/chat-1.0-SNAPSHOT/ui/signup" method="get">
                 <button type="submit">Зарегистрироваться</button>
        </form>
        <form action="/chat-1.0-SNAPSHOT/ui/login" method="get">
                         <button type="submit">Войти в систему</button>
                </form>
    </c:when>

    <c:otherwise>
         <form action="/chat-1.0-SNAPSHOT/ui/send-message" method="GET">
                    <button type="submit">Отправить сообщение</button>
         </form>
         <form action="/chat-1.0-SNAPSHOT/ui/get-message" method="GET">
                             <button type="submit">Просмотреть сообщения</button>
         </form>
         <c:if test = "${user.role == 'ADMIN'}">
         <form action="/chat-1.0-SNAPSHOT/ui/admin/statistics" method="GET">
                                      <button type="submit">Просмотреть статистику</button>
                  </form>
         </c:if>
    </c:otherwise>
</c:choose>



</body>
</html>