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
        <a href="${pageContext.request.contextPath}/ui/signup">
                 <button>Зарегистрироваться</button>
        </a>
        <br><br>


        <a href="${pageContext.request.contextPath}/ui/login">
        <button>Войти в систему</button>
        </a>
        <br><br>
    </c:when>

    <c:otherwise>
         <a href="${pageContext.request.contextPath}/ui/send-message" >
               <button>Отправить сообщение</button>
         </a>
         <br><br>
         <a href="${pageContext.request.contextPath}/ui/show-senders" >
               <button>Просмотреть сообщения</button>
         </a>
         <br><br>

         <c:if test = "${user.role == 'ADMIN'}">
            <a href="${pageContext.request.contextPath}/ui/admin/statistics" >
                <button>Просмотреть статистику</button>
            </a>
            <br><br>
         </c:if>

         <a href="${pageContext.request.contextPath}/api/logOut" >
               <button>Выйти из сессии</button>
         </a>
    </c:otherwise>
</c:choose>



</body>
</html>