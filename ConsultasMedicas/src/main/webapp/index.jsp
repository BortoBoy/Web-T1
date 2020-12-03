<%-- 
    Document   : admin
    Created on : Dec 2, 2020, 10:42:22 PM
    Author     : borto
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.ufscar.dc.dsw.domain.Paciente"%>
<%@page import="br.ufscar.dc.dsw.dao.PacienteDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Medico"%>
<%@page import="br.ufscar.dc.dsw.dao.MedicoDAO"%>
<%
    if(request.getSession().getAttribute("admin") == null){
        request.getRequestDispatcher("/login").forward(request, response);
    }
    MedicoDAO medicoDAO = new MedicoDAO();
    ArrayList<Medico> medicos = medicoDAO.getAll();
    PacienteDAO pacienteDAO = new PacienteDAO();
    ArrayList<Paciente> pacientes = pacienteDAO.getAll();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Admin page</h1>
        
        <h3>Crud de Médicos</h3>
        <a href="medico/create">Adicionar</a>
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
            
        <h3>Crud de Pacientes</h3>
        <a href="paciente/create">Adicionar</a>
        <table border="1">
            <thead>
                <tr>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <% for (Paciente paciente : pacientes) { %>
                    <tr>
                        <td><%= paciente.getCpf()%></td>
                        <td><%= paciente.getNome()%></td>
                        <td><%= paciente.getSexoStr()%></td>
                        <td><%= paciente.getEmail()%></td>
                    </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
