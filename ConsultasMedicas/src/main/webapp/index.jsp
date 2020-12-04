<%-- 
    Document   : admin
    Created on : Dec 2, 2020, 10:42:22 PM
    Author     : borto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.domain.Medico"%>
<%@page import="br.ufscar.dc.dsw.dao.MedicoDAO"%>
<%
    MedicoDAO medicoDAO = new MedicoDAO();
    ArrayList<Medico> medicos = null;
    String especialidadeStr = request.getParameter("e");
    int especialidade = -1;
    if(especialidadeStr != null){
        especialidade = Integer.parseInt(especialidadeStr);
        medicos = medicoDAO.getByEspecialidade(especialidade);
    }
    else{
        medicos = medicoDAO.getAll();
    }
%>


<!DOCTYPE html>
<fmt:bundle basename="messages">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <h1><fmt:message key="system_description"/></h1>
        <a href="login.jsp"><fmt:message key="link_to_login"/></a><br><br>
        
        <% for (Medico.Especialidades e : Medico.Especialidades.values()) { %>
            <a href="?e=<%= e.ordinal() %>"
                <% if(especialidade == e.ordinal()){%>
                  style="font-weight: bold;"
                <%}%>
            >
                <fmt:message key="<%= e.name() %>"/>
            </a><br>
        <%}%>
        <h3><fmt:message key="registred_doctors"/>
            <% if(especialidade != -1){%>
                (<fmt:message key="<%= Medico.Especialidades.values()[especialidade].name() %>"/>)
            <%}%>
        </h3>
        <table border="1">
            <thead>
                <tr>
                    <th>CRM</th>
                    <th><fmt:message key="field_name" /></th>
                    <th><fmt:message key="field_especialidade" /></th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <% for (Medico medico : medicos) { %>
                    <tr>
                        <td><%= medico.getCrm() %></td>
                        <td><%= medico.getNome()%></td>
                        <td><fmt:message key="<%= medico.getEsepcialidadeStr()%>"/></td>
                        <td><%= medico.getEmail()%></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
</fmt:bundle>
