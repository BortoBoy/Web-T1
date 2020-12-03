<%-- 
    Document   : admin
    Created on : Dec 2, 2020, 10:42:22 PM
    Author     : borto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ufscar.dc.dsw.domain.Paciente"%>
<%
    Paciente paciente = (Paciente) request.getSession().getAttribute("paciente");
    if(paciente == null){
        request.getRequestDispatcher("/login").forward(request, response);
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paciente Page</title>
    </head>
    <body>
        <h1>Paciente page</h1>
        <p>Bem vindo <%= paciente.getNome() %></p>
    </body>
</html>
