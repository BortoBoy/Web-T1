<%-- 
    Document   : createPaciente
    Created on : Dec 3, 2020, 6:10:51 PM
    Author     : borto
--%>

<%@page import="br.ufscar.dc.dsw.dao.PacienteDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Paciente.Sexos"%>
<%@page import="br.ufscar.dc.dsw.domain.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    if(request.getSession().getAttribute("admin") == null){
        response.sendRedirect("login");
        return;
    }
    PacienteDAO pacienteDAO = new PacienteDAO();
    Paciente paciente = pacienteDAO.getOne(Long.parseLong(request.getParameter("id")));
%>

<fmt:bundle basename="messages">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Patient Page</title>
    </head>
    <body>
        <h1><fmt:message key="edit_patient_title"/></h1>
        <form action="paciente/update" method="POST">
            <label><fmt:message key="field_name"/></label>
            <input name="nome" value="<%= paciente.getNome() %>" type="text" maxlength="256"/><br>
            <label>Email</label>
            <input name="email" value="<%= paciente.getEmail()%>" type="email" maxlength="256"/><br>
            <label><fmt:message key="field_password"/></label>
            <input name="senha" value="<%= paciente.getSenha()%>" type="password" maxlength="48"/><br>
            <label>CPF</label>
            <input name="cpf" value="<%= paciente.getCpf()%>" type="text" maxlength="48"/><br>
            <input name="id" value="<%= paciente.getId()%>" type="hidden" maxlength="48"/>
            <label><fmt:message key="field_tel"/></label>
            <input name="telefone" value="<%= paciente.getTelefone()%>" type="text" maxlength="20"/><br>
            <label><fmt:message key="field_birth"/></label><br>
            <label><fmt:message key="field_day"/>:</label>
            <input name="dia" value="<%= paciente.getDia() %>" type="number" min="1" max="31"/>
            <label><fmt:message key="field_month"/></label>
            <input name="mes" value="<%= paciente.getMes() %>" type="number" min="1" max="12"/>
            <label><fmt:message key="field_year"/>:</label>
            <input name="ano" value="<%= paciente.getAno() %>" type="number" min="1800" max="2020"/>
            <br>
            <label><fmt:message key="field_sex"/>:</label>
            <select name="sexo" id="cars">
                <% for (Paciente.Sexos s : Paciente.Sexos.values()) { %>
                    <option
                        <% if(paciente.getSexo()== s.ordinal()){%>
                            selected="selected"
                        <%}%>
                        value="<%= s.ordinal() %>"><fmt:message key="<%= s.name() %>"/></option>
                <%}%>
            </select>
            <input type="submit" value="<fmt:message key="submit"/>" />
        </form>
    </body>
</html>
</fmt:bundle>
