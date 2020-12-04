package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PacienteDAO;
import br.ufscar.dc.dsw.domain.Paciente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreatePaciente", urlPatterns = { "/paciente/create" })
public class CreatePacienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){
            response.sendRedirect("login");
            return;
        }
        PacienteDAO pacienteDAO = new PacienteDAO();
        Paciente paciente = new Paciente();
        try {
            paciente.setNome(request.getParameter("nome"));
            paciente.setEmail(request.getParameter("email"));
            paciente.setSenha(request.getParameter("senha"));
            paciente.setCpf(request.getParameter("cpf"));
            paciente.setSexo(Integer.parseInt(request.getParameter("sexo")));
            paciente.setTelefone(request.getParameter("telefone"));
            paciente.setAniversario(
                Integer.parseInt(request.getParameter("dia")),
                Integer.parseInt(request.getParameter("mes")),
                Integer.parseInt(request.getParameter("ano"))
            );
            pacienteDAO.insert(paciente);
            response.sendRedirect("/ConsultasMedicas/admin.jsp");
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
    }
}