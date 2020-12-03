<%-- 
    Document   : admin
    Created on : Dec 2, 2020, 10:42:22 PM
    Author     : borto
--%>

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

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <h1>Agendamento de consultas médicas</h1>
        <a href="login.jsp">Fazer Login</a><br><br>
        
        <% for (Medico.Especialidades e : Medico.Especialidades.values()) { %>
            <a href="?e=<%= e.ordinal() %>"
                <% if(especialidade == e.ordinal()){%>
                  style="font-weight: bold;"
                <%}%>
            >
                <%= e.name() %>
            </a><br>
        <%}%>
        <h3>Médicos cadastrados
            <% if(especialidade != -1){%>
                (<%= Medico.Especialidades.values()[especialidade].name() %>)
            <%}%>
        </h3>
        <table border="1">
            <thead>
                <tr>
                    <th>CRM</th>
                    <th>Nome</th>
                    <th>Especialidade</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <% for (Medico medico : medicos) { %>
                    <tr>
                        <td><%= medico.getCrm() %></td>
                        <td><%= medico.getNome()%></td>
                        <td><%= medico.getEsepcialidadeStr()%></td>
                        <td><%= medico.getEmail()%></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
