package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PacienteDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeletePaciente", urlPatterns = { "/paciente/delete" })
public class DeletePacienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){
            response.sendRedirect("login");
            return;
        }
        PacienteDAO pacienteDAO = new PacienteDAO();
        try {
            String cpf = request.getParameter("cpf");
            pacienteDAO.delete(cpf);
            response.sendRedirect("/ConsultasMedicas/admin.jsp");
            
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        
    }
}