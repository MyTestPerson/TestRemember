<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin</title>
</head>
<body>
admin

<br>
<a href="/"><button type="submit" >Home</button></a>
<br>
<br>

<form method="post" action="/logout">


    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Exit</button>
</form>

</body>
</html>