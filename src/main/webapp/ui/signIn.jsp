<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
                <html>
                	<head>
                		<meta charset="utf-8">
                		<meta name="viewport" content="width=device-width, initial-scale=1">
                		<title>signIn</title>
                	</head>
                	<body>
                		<form action="/chat-1.0-SNAPSHOT/api/login" method="POST">
                                <p>
                                    <legend>Login:<br></legend>
                                    <textarea rows="1" cols="50" name="login" required></textarea>
                                </p>
                                 <p>
                                     <legend>Password:<br></legend>
                                     <textarea rows="1" cols="50" name="password" required></textarea>
                                 </p>

                                <p><input type="submit" value="Submit"></p>
                        </form>

                        <form action="/chat-1.0-SNAPSHOT/api/message" method="GET">
                             <p><input type="submit" value="Go to messages"></p>
                        </form>
			        </body>
			    </html>