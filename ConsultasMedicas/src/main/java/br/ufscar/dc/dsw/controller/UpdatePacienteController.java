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

@WebServlet(name = "UpdatePaciente", urlPatterns = { "/paciente/update" })
public class UpdatePacienteController extends HttpServlet {

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
            String cpf = request.getParameter("old_cpf");
            paciente.setNome(request.getParameter("nome"));
            paciente.setEmail(request.getParameter("email"));
            paciente.setSenha(request.getParameter("senha"));
            paciente.setCpf(request.getParameter("new_cpf"));
            paciente.setTelefone(request.getParameter("telefone"));
            paciente.setAniversario(
                Integer.parseInt(request.getParameter("dia")),
                Integer.parseInt(request.getParameter("mes")),
                Integer.parseInt(request.getParameter("ano"))
            );
            paciente.setSexo(Integer.parseInt(request.getParameter("sexo")));
            pacienteDAO.update(paciente, cpf);
            response.sendRedirect("/ConsultasMedicas/admin.jsp");
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
    }
}