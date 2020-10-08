<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>

<body>
Registration
<br>
<br>

<form name="user" action="/registration" method="post">

    <input type="text" name="username" value="user"/><br>

    <input  type="password" name="password" value="1111"/><br>

<#--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

    <br>

    <button type="submit" id="submit">Register now</button>

</form>


</body>
</html>