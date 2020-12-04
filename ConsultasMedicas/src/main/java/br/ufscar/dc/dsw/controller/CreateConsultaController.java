package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.ConsultaDAO;
import br.ufscar.dc.dsw.domain.Consulta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateConsulta", urlPatterns = { "/consulta/create" })
public class CreateConsultaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            if(request.getSession().getAttribute("paciente") == null){
                response.sendRedirect("/ConsultasMedicas/login");
                return;
            }
            ConsultaDAO consultaDAO = new ConsultaDAO();
            Consulta consulta = new Consulta();
            consulta.setPaciente(Long.parseLong(request.getParameter("paciente")));
            consulta.setMedico(Long.parseLong(request.getParameter("medico")));
            consulta.setData(
                    Integer.parseInt(request.getParameter("ano")),
                    Integer.parseInt(request.getParameter("mes")),
                    Integer.parseInt(request.getParameter("dia")),
                    Integer.parseInt(request.getParameter("hora")),
                    Integer.parseInt(request.getParameter("minuto"))
            );
            consultaDAO.insert(consulta);
            response.sendRedirect("/ConsultasMedicas/paciente.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}