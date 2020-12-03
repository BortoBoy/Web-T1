<%-- 
    Document   : createMedico
    Created on : Dec 3, 2020, 6:10:51 PM
    Author     : borto
--%>

<%@page import="br.ufscar.dc.dsw.domain.Medico.Especialidades"%>
<%@page import="br.ufscar.dc.dsw.domain.Medico"%>
<%@page import="br.ufscar.dc.dsw.dao.MedicoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if(request.getSession().getAttribute("admin") == null){
        response.sendRedirect("login");
        return;
    }
    MedicoDAO medicoDAO = new MedicoDAO();
    Medico medico = medicoDAO.getbyCrm(request.getParameter("crm"));
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Medico Page</title>
    </head>
    <body>
        <h1>Editar Médico</h1>
        <form action="medico/update" method="POST">
            <label>Name</label>
            <input name="nome" value="<%= medico.getNome() %>" type="text" maxlength="256"/><br>
            <label>Email</label>
            <input name="email" value="<%= medico.getEmail()%>" type="email" maxlength="256"/><br>
            <label>Senha</label>
            <input name="senha" value="<%= medico.getSenha()%>" type="password" maxlength="48"/><br>
            <label>CRM</label>
            <input name="new_crm" value="<%= medico.getCrm() %>" type="text" maxlength="48"/><br>
            <input name="old_crm" value="<%= medico.getCrm() %>" type="hidden" maxlength="48"/><br>
            <label>Especialidade:</label>
            <select name="especialidade" id="cars">
                <% for (Medico.Especialidades e : Medico.Especialidades.values()) { %>
                <option
                    <% if(medico.getEspecialidade() == e.ordinal()){%>
                        selected="selected"
                    <%}%>
                    value="<%= e.ordinal() %>"><%= e.name() %></option>
                <%}%>
            </select>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
