<%-- 
    Document   : admin
    Created on : Dec 2, 2020, 10:42:22 PM
    Author     : borto
--%>

<%@page import="br.ufscar.dc.dsw.domain.Paciente"%>
<%@page import="br.ufscar.dc.dsw.domain.Consulta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.domain.Medico"%>
<%@page import="br.ufscar.dc.dsw.dao.ConsultaDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%  
    Medico medico = (Medico) request.getSession().getAttribute("medico");
    if(medico == null){
        response.sendRedirect("/ConsultasMedicas/login");
        return;
    }
    ConsultaDAO consultaDAO = new ConsultaDAO();
    ArrayList<Consulta> consultas = consultaDAO.getbyMedico(medico.getCrm());
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medico Page</title>
    </head>
    <body>
        <h1><fmt:message key="welcome"/> <%= medico.getNome() %></h1>
        
        <h3><fmt:message key="your_appointments"/></h3>
        <table border="1">
            <thead>
                <tr>
                    <th><fmt:message key="field_patient"/></th>
                    <th><fmt:message key="field_sex"/></th>
                    <th>CPF</th>
                    <th><fmt:message key="field_date_time"/></th>
                </tr>
            </thead>
            <tbody>
                <% for (Consulta consulta : consultas) { %>
                    <tr>
                        <td><%= consulta.getNome_paciente() %></td>
                        <td>
                            <fmt:message key="<%= Paciente.Sexos.values()[consulta.getSexo_paciente()].name() %>"/>
                        </td>
                        <td><%= consulta.getCpf_paciente() %></td>
                        <td><%= consulta.getData()%></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>

</fmt:bundle>