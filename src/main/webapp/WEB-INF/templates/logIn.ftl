<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>


    <form name="user" method="post" action="/login">
        <input type="text" name="username" value="user"/>

        <input type="password" name="password" value="1111"/>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <br>

        <label for="remember">Remember me</label>
        <input type="checkbox" name="remember-me" value="true">

        <br><br>

        <button type="submit">Log in</button>

    </form>

    <br><br>




</body></html>