<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
                <html>
                	<head>
                		<meta charset="utf-8">
                		<meta name="viewport" content="width=device-width, initial-scale=1">
                		<title>Вход</title>
                	</head>
                	<body>
                	    <%
                            String exceptionMessage = (String) request.getSession().getAttribute("exceptionMessage");
                            if(exceptionMessage != null){
                                out.println("<p>" + exceptionMessage + "</p>");
                            }
                        %>
                        <form action="<c:url value="/api/login"/>" method="POST">
                                <p>
                                     <legend>Логин:      </legend>
                                     <input type="text" name="login" required>
                                </p>
                                <p>
                                     <legend>Пароль:  </legend>
                                     <input type="password"  name="password" required>
                                </p>

                                <p><input type="submit" value="Войти"></p>
                        </form>

                        <br><br>

                        <form action="<c:url value="/ui/"/>" method="GET">
                                <p><input type="submit" value="Назад"></p>
                        </form>


			        </body>
			    </html>