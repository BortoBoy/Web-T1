<%-- 
    Document   : createMedico
    Created on : Dec 3, 2020, 6:10:51 PM
    Author     : borto
--%>

<%@page import="br.ufscar.dc.dsw.domain.Medico.Especialidades"%>
<%@page import="br.ufscar.dc.dsw.domain.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    if(request.getSession().getAttribute("admin") == null){
        response.sendRedirect("login");
        return;
    }
    Medico medico = new Medico();
%>

<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Medico Page</title>
    </head>
    <body>
        <h1><fmt:message key="add_doctor_title"/></h1>
        <form action="medico/create" method="POST">
            <label><fmt:message key="field_name"/></label>
            <input name="nome" value="" type="text" maxlength="256"/><br>
            <label>Email</label>
            <input name="email" value="" type="email" maxlength="256"/><br>
            <label><fmt:message key="field_password"/></label>
            <input name="senha" value="" type="password" maxlength="48"/><br>
            <label>CRM</label>
            <input name="crm" value="" type="text" maxlength="48"/><br>
            <label><fmt:message key="field_especialidade"/>:</label>
            <select name="especialidade" id="cars">
                <% for (Medico.Especialidades e : Medico.Especialidades.values()) { %>
                    <option value="<%= e.ordinal() %>"><fmt:message key="<%= e.name() %>"/></option>
                <%}%>
            </select>
            <input type="submit" value="<fmt:message key="submit"/>" />
        </form>
    </body>
</html>
</fmt:bundle>
