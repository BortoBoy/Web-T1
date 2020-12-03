<%-- 
    Document   : login.jsp
    Created on : Dec 2, 2020, 10:26:23 PM
    Author     : borto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="login" method="post">
            <label>Usuário</label><input type="text" name="user" maxlength="200"><br>
            <label>Senha</label><input type="password" name="password" maxlength="200"><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
