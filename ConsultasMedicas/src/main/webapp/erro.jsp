<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<% 
    Exception ex = (Exception) request.getSession().getAttribute("error");
%>
<html>
    <head>
        <title>Error Page</title>
    </head>
    <body>
        <h1>Aconteceu um erro :(</h1>
        <p> <%= ex %> </p>
    </body>
</html>