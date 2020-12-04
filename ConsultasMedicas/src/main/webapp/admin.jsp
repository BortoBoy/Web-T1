<%-- 
    Document   : admin
    Created on : Dec 2, 2020, 10:42:22 PM
    Author     : borto
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="br.ufscar.dc.dsw.domain.Paciente"%>
<%@page import="br.ufscar.dc.dsw.dao.PacienteDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Medico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.dao.MedicoDAO"%>
<%
    if(request.getSession().getAttribute("admin") == null){
        response.sendRedirect("login");
        return;
    }
    MedicoDAO medicoDAO = new MedicoDAO();
    ArrayList<Medico> medicos = medicoDAO.getAll();
    PacienteDAO pacienteDAO = new PacienteDAO();
    ArrayList<Paciente> pacientes = pacienteDAO.getAll();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1><fmt:message key="welcome"/> Admin</h1>
        
        <h3><fmt:message key="doctors_crud"/></h3>
        <a href="newMedico.jsp"><fmt:message key="add"/></a>
        <table border="1">
            <thead>
                <tr>
                    <th>CRM</th>
                    <th><fmt:message key="field_name"/></th>
                    <th><fmt:message key="field_especialidade"/></th>
                    <th>Email</th>
                    <th><fmt:message key="actions"/></th>
                </tr>
            </thead>
            <tbody>
                <% for (Medico medico : medicos) { %>
                    <tr>
                        <td><%= medico.getCrm() %></td>
                        <td><%= medico.getNome()%></td>
                        <td><fmt:message key="<%= medico.getEsepcialidadeStr()%>"/></td>
                        <td><%= medico.getEmail()%></td>
                        <td>
                            <a href="editMedico.jsp?crm=<%= medico.getCrm() %>"><fmt:message key="action_edit" /></a>
                            <a href="medico/delete?crm=<%= medico.getCrm() %>"><fmt:message key="action_delete" /></a>
                        </td>
                    </tr>
                <%}%>
            </tbody>
        </table>
            
        <h3><fmt:message key="patients_crud" /></h3>
        <a href="newPaciente.jsp"><fmt:message key="add" /></a>
        <table border="1">
            <thead>
                <tr>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th><fmt:message key="field_sex" /></th>
                    <th>Email</th>
                    <th><fmt:message key="actions" /></th>
                </tr>
            </thead>
            <tbody>
                <% for (Paciente paciente : pacientes) { %>
                    <tr>
                        <td><%= paciente.getCpf()%></td>
                        <td><%= paciente.getNome()%></td>
                        <td><fmt:message key="<%= paciente.getSexoStr()%>" /></td>
                        <td><%= paciente.getEmail()%></td>
                        <td>
                            <a href="editPaciente.jsp?cpf=<%= paciente.getCpf()%>"><fmt:message key="action_edit" /></a>
                            <a href="paciente/delete?cpf=<%= paciente.getCpf()%>"><fmt:message key="action_delete" /></a>
                        </td>
                    </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
</fmt:bundle>
