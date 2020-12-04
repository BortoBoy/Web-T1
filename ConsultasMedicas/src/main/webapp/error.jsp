<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    String raw_message = exception.getMessage();
    String[] parts = raw_message.split(": ");
    String message = parts[1];
%>
<html>
    <head>
        <title>Error Page</title>
    </head>
    <body>
        <h1>Você fez algo muito errado amigo :(</h1>
        <h3><%= message %><br/> </h3>
        <h5>Não faça mais isso</5>
    </body>
</html>