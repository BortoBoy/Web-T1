<%-- 
    Document   : admin
    Created on : Dec 2, 2020, 10:42:22 PM
    Author     : borto
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="br.ufscar.dc.dsw.dao.MedicoDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Medico"%>
<%@page import="br.ufscar.dc.dsw.dao.ConsultaDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Consulta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.domain.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    Paciente paciente = (Paciente) request.getSession().getAttribute("paciente");
    if(paciente == null){
        response.sendRedirect("login");
        return;
    }
    ConsultaDAO consultaDAO = new ConsultaDAO();
    MedicoDAO medicoDAO = new MedicoDAO();
    ArrayList<Consulta> consultas = consultaDAO.getbyPatient(paciente.getCpf());
    ArrayList<Medico> medicos = medicoDAO.getAll();
%>


<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Page</title>
    </head>
    <body>
        <h1><fmt:message key="welcome"/> <%= paciente.getNome() %></h1>
        
        <h3><fmt:message key="your_appointments"/></h3>
        <table border="1">
            <thead>
                <tr>
                    <th><fmt:message key="field_medico"/></th>
                    <th><fmt:message key="field_especialidade"/></th>
                    <th>CRM</th>
                    <th><fmt:message key="field_date_time"/></th>
                </tr>
            </thead>
            <tbody>
                <% for (Consulta consulta : consultas) { %>
                    <tr>
                        <td><fmt:message key="doctor_prefix"/> <%= consulta.getNome_medico() %></td>
                        <td>
                            <fmt:message key="<%= Medico.Especialidades.values()[consulta.getEspecialidade_medico()].name() %>"/>
                        </td>
                        <td><%= consulta.getCrm_medico() %></td>
                        <td><%= consulta.getData()%></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
            
        <h3><fmt:message key="set_appointment"/></h3>
        <form action="consulta/create" method="post">
            <input type="hidden" value="<%= paciente.getCpf() %>" name="paciente" />
            <label><fmt:message key="field_medico"/>:</label>
            <select name="medico">
                <% for (Medico m : medicos) { %>
                <option
                    value="<%= m.getCrm() %>">
                    <%= m.getNome() %>
                    -
                    <fmt:message key="<%= m.getEsepcialidadeStr() %>"/>
                </option>
                <%}%>
            </select><br>
            <label><fmt:message key="field_date_time"/>:</label><br>
            <label><fmt:message key="field_day"/>:</label>
            <input name="dia" value="" type="number" min="1" max="31"/>
            <label><fmt:message key="field_month"/>:</label>
            <input name="mes" value="" type="number" min="1" max="12"/>
            <label><fmt:message key="field_year"/>:</label>
            <input name="ano" value="" type="number"
            min="<%= LocalDateTime.now().getYear() %>"/>
            <label><fmt:message key="field_hour"/>:</label>
            <input name="hora" value="" type="number" min="7" max="18"/>
            <label><fmt:message key="field_minute"/>:</label>
            <select name="minuto">
                <option value="0">00</option>
                <option value="30">30</option>
            </select>
            <br>
            <input type="submit" value="<fmt:message key="submit"/>" />
        </form>
        
    </body>
</html>
</fmt:bundle>
