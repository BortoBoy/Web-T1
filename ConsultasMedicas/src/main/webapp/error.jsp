<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    String raw_message = exception.getMessage();
    String[] parts = raw_message.split(": ");
    String message = parts[1];
%>
<fmt:bundle basename="messages">
<html>
    <head>
        <title>Error Page</title>
    </head>
    <body>
        <h1><fmt:message key="error_report1"/></h1>
        <h3><%= message %><br/></h3>
        <h5><fmt:message key="error_report2"/></5>
    </body>
</html>
</fmt:bundle>