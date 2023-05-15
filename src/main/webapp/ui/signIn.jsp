<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <%
                            String path = (String) request.getAttribute("path");
                            out.println("<form method=\"POST\" action=\"" + path + "/api/login\">");
                    %>

                                <p>
                                    <legend>Логин:      </legend>
                                    <input type="text" name="login" required></textarea>
                                </p>
                                 <p>
                                     <legend>Пароль:  </legend>
                                     <input type="password"  name="password" required></textarea>
                                 </p>

                                <p><input type="submit" value="Войти"></p>
                        </form>

                        <br><br>

                        <%
                              out.println("<form method=\"GET\" action=\"" + path + "/ui/\">");
                        %>
                                <p><input type="submit" value="Return"></p>
                        </form>


			        </body>
			    </html>