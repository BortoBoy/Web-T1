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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacient Page</title>
    </head>
    <body>
        <h1>Paciente page</h1>
        <p>Bem vindo <%= paciente.getNome() %></p>
        
        <h3>Suas Consultas</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Medico</th>
                    <th>Especialidade</th>
                    <th>CRM</th>
                    <th>Data e Hora</th>
                </tr>
            </thead>
            <tbody>
                <% for (Consulta consulta : consultas) { %>
                    <tr>
                        <td>Dr(a) <%= consulta.getNome_medico() %></td>
                        <td>
        <%= Medico.Especialidades.values()[consulta.getEspecialidade_medico()].name() %>
                        </td>
                        <td><%= consulta.getCrm_medico() %></td>
                        <td><%= consulta.getData()%></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
            
        <h3>Agendar uma Consulta</h3>
        <form action="consulta/create" method="post">
            <input type="hidden" value="<%= paciente.getCpf() %>" name="paciente" />
            <label>Medico:</label>
            <select name="medico">
                <% for (Medico m : medicos) { %>
                <option
                    value="<%= m.getCrm() %>">
                    <%= m.getNome() %>
                    -
                    <%= m.getEsepcialidadeStr() %>
                </option>
                <%}%>
            </select><br>
            <label>Data e Hora:</label><br>
            <label>Dia:</label>
            <input name="dia" value="" type="number" min="1" max="31"/>
            <label>Mes:</label>
            <input name="mes" value="" type="number" min="1" max="12"/>
            <label>Ano:</label>
            <input name="ano" value="" type="number"
            min="<%= LocalDateTime.now().getYear() %>"/>
            <label>Hora:</label>
            <input name="hora" value="" type="number" min="7" max="18"/>
            <label>Minuto:</label>
            <select name="minuto">
                <option value="0">00</option>
                <option value="30">30</option>
            </select>
            <br>
            <input type="submit" value="Enviar" />
        </form>
        
    </body>
</html>
