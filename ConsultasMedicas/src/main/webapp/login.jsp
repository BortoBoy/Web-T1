<%-- 
    Document   : login.jsp
    Created on : Dec 2, 2020, 10:26:23 PM
    Author     : borto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="login" method="post">
            <label><fmt:message key="field_user" /></label><br>
            <input type="text" name="user" maxlength="256"><br>
            <label><fmt:message key="field_password" /></label><br>
            <input type="password" name="password" 
            minlength="6" maxlength="48"><br><br>
            <input type="submit" value="<fmt:message key="submit"/>">
        </form>
    </body>
</html>
</fmt:bundle>
