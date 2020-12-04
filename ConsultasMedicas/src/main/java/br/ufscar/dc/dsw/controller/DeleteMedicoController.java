package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.MedicoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteMedico", urlPatterns = { "/medico/delete" })
public class DeleteMedicoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){
            response.sendRedirect("login");
            return;
        }
        MedicoDAO medicoDAO = new MedicoDAO();
        try {
            String crm = request.getParameter("crm");
            medicoDAO.delete(crm);
            response.sendRedirect("/ConsultasMedicas/admin.jsp");
            
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        
    }
}