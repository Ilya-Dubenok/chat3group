<%@ page language="java"
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<head>
    <title>LogUp</title>
</head>
<body>
<header>
    <h1>Registration</h1>
</header>
<form method="POST">
    <label for="login">Login:</label>
    <input type="text" id="login" name="login" required><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>
    <label for="checkPassword">Password again:</label>
    <input type="password" id="checkPassword" name="checkPassword" required><br><br>
    <label for="firstName">First name:</label>
    <input type="text" id="firstName" name="firstName" required><br><br>
    <label for="firstName">Last name:</label>
    <input type="text" id="firstName" name="lastName" required><br><br>
    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname"> If exists<br><br>
    <label for="dateOfBirth">Date of birth:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" required pattern="dd-mm-yyyy"><br><br>
    <input type="submit" value="Send">
</form>
</body>
</html>