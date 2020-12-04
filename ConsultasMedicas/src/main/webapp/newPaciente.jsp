<%-- 
    Document   : createMedico
    Created on : Dec 3, 2020, 6:10:51 PM
    Author     : borto
--%>

<%@page import="br.ufscar.dc.dsw.domain.Paciente.Sexos"%>
<%@page import="br.ufscar.dc.dsw.domain.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    if(request.getSession().getAttribute("admin") == null){
        response.sendRedirect("login");
        return;
    }
    Paciente medico = new Paciente();
%>

<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Patient Page</title>
    </head>
    <body>
        <h1><fmt:message key="add_patient_title"/></h1>
        <form action="paciente/create" method="POST">
            <label><fmt:message key="field_name"/></label>
            <input name="nome" value="" type="text" maxlength="256"/><br>
            <label>Email</label>
            <input name="email" value="" type="email" maxlength="256"/><br>
            <label><fmt:message key="field_password"/></label>
            <input name="senha" value="" type="password" maxlength="48"/><br>
            <label>CPF</label>
            <input name="cpf" value="" type="text" maxlength="48"/><br>
            <label><fmt:message key="field_tel"/></label>
            <input name="telefone" value="" type="text" maxlength="20"/><br>
            <label><fmt:message key="field_birth"/></label>
            <label><fmt:message key="field_day"/>:</label>
            <input name="dia" value="" type="number" min="1" max="31"/>
            <label><fmt:message key="field_month"/>:</label>
            <input name="mes" value="" type="number" min="1" max="12"/>
            <label><fmt:message key="field_year"/>:</label>
            <input name="ano" value="" type="number" min="1800" max="2020"/>
            <br>
            <label><fmt:message key="field_sex"/>:</label>
            <select name="sexo" id="cars">
                <% for (Paciente.Sexos s : Paciente.Sexos.values()) { %>
                    <option value="<%= s.ordinal() %>"><fmt:message key="<%= s.name() %>"/></option>
                <%}%>
            </select>
            <input type="submit" value="<fmt:message key="submit"/>"/>
        </form>
    </body>
</html>
</fmt:bundle>
