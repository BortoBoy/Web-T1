<%-- 
    Document   : createPaciente
    Created on : Dec 3, 2020, 6:10:51 PM
    Author     : borto
--%>

<%@page import="br.ufscar.dc.dsw.dao.PacienteDAO"%>
<%@page import="br.ufscar.dc.dsw.domain.Paciente.Sexos"%>
<%@page import="br.ufscar.dc.dsw.domain.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if(request.getSession().getAttribute("admin") == null){
        response.sendRedirect("login");
        return;
    }
    PacienteDAO pacienteDAO = new PacienteDAO();
    Paciente paciente = pacienteDAO.getbyCpf(request.getParameter("cpf"));
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Patient Page</title>
    </head>
    <body>
        <h1>Adicionar Paciente</h1>
        <form action="paciente/update" method="POST">
            <label>Name</label>
            <input name="nome" value="<%= paciente.getNome() %>" type="text" maxlength="256"/><br>
            <label>Email</label>
            <input name="email" value="<%= paciente.getEmail()%>" type="email" maxlength="256"/><br>
            <label>Senha</label>
            <input name="senha" value="<%= paciente.getSenha()%>" type="password" maxlength="48"/><br>
            <label>CPF</label>
            <input name="new_cpf" value="<%= paciente.getCpf()%>" type="text" maxlength="48"/><br>
            <input name="old_cpf" value="<%= paciente.getCpf()%>" type="hidden" maxlength="48"/><br>
            <label>Telefone</label>
            <input name="telefone" value="<%= paciente.getTelefone()%>" type="text" maxlength="20"/><br>
            <label>Aniversario</label><br>
            <label>Dia:</label>
            <input name="dia" value="<%= paciente.getDia() %>" type="number" min="1" max="31"/>
            <label>Mes:</label>
            <input name="mes" value="<%= paciente.getMes() %>" type="number" min="1" max="12"/>
            <label>Ano:</label>
            <input name="ano" value="<%= paciente.getAno() %>" type="number" min="1800" max="2020"/>
            <br>
            <label>Sexo:</label>
            <select name="sexo" id="cars">
                <% for (Paciente.Sexos s : Paciente.Sexos.values()) { %>
                    <option
                        <% if(paciente.getSexo()== s.ordinal()){%>
                            selected="selected"
                        <%}%>
                        value="<%= s.ordinal() %>"><%= s.name() %></option>
                <%}%>
            </select>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
