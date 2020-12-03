<%-- 
    Document   : admin
    Created on : Dec 2, 2020, 10:42:22 PM
    Author     : borto
--%>

<%
    if(request.getSession().getAttribute("medico") == null){
        request.getRequestDispatcher("/login").forward(request, response);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medico Page</title>
    </head>
    <body>
        <h1>Medico page</h1>
    </body>
</html>
