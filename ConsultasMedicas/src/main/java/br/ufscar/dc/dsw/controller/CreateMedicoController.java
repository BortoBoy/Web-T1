package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.MedicoDAO;
import br.ufscar.dc.dsw.domain.Medico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateMedico", urlPatterns = { "/medico/create" })
public class CreateMedicoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){
            response.sendRedirect("login");
            return;
        }
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = new Medico();
        try {
            medico.setNome(request.getParameter("nome"));
            medico.setEmail(request.getParameter("email"));
            medico.setSenha(request.getParameter("senha"));
            medico.setCrm(request.getParameter("crm"));
            medico.setEspecialidade(Integer.parseInt(request.getParameter("especialidade")));
            medicoDAO.insert(medico);
            response.sendRedirect("/ConsultasMedicas/admin.jsp");
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
    }
}