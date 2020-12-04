package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Consulta;
import java.util.List;

public class TestConsultaDAO {

    public static void main(String[] args) throws Exception {
        // Execute aqui suas ações de teste
        // consultaInsertion();
        // consultaDeletion();
        // consultaGetOne();
        // consultaGetAll();
        // consultaGetAllByMedico();
        consultaGetAllByPatient();
        
    }
    
    public static void consultaInsertion() throws Exception{
        ConsultaDAO consultaDAO = new ConsultaDAO();
        Consulta consulta = consultaGenerator();
        consultaDAO.insert(consulta);
        System.out.println("[INFO] Consulta inserido com sucesso");
    }
    
    public static void consultaDeletion() throws Exception{
        ConsultaDAO consultaDAO = new ConsultaDAO();
        consultaDAO.delete(12L);
        System.out.println("[INFO] Consulta deletado com sucesso");
    }
    
    public static void consultaGetOne() throws Exception{
        ConsultaDAO consultaDAO = new ConsultaDAO();
        Consulta consulta = consultaDAO.getbyId(11L);
        System.out.println("[INFO] Consulta requisitado com sucesso");
        System.out.println(consulta.toString());
    }
    
    public static void consultaGetAll() throws Exception{
        ConsultaDAO consultaDAO = new ConsultaDAO();
        List<Consulta> consultas = consultaDAO.getAll();
        System.out.println("[INFO] Consultas requisitados com sucesso");
        for (Consulta consulta : consultas) {
            System.out.println(consulta.toString());
        }
    }
    
    public static void consultaGetAllByPatient() throws Exception{
        ConsultaDAO consultaDAO = new ConsultaDAO();
        List<Consulta> consultas = consultaDAO.getbyPatient("123.123.123-12");
        System.out.println("[INFO] Consultas requisitados com sucesso");
        for (Consulta consulta : consultas) {
            System.out.println(consulta.toString());
        }
    }
    
    public static void consultaGetAllByMedico() throws Exception{
        ConsultaDAO consultaDAO = new ConsultaDAO();
        List<Consulta> consultas = consultaDAO.getbyMedico("123123");
        System.out.println("[INFO] Consultas requisitados com sucesso");
        for (Consulta consulta : consultas) {
            System.out.println(consulta.toString());
        }
    }
    
    private static Consulta consultaGenerator() throws Exception{
        Consulta consulta = new Consulta();
        consulta.setCrm_medico("123123");
        consulta.setCpf_paciente("321.321.321-32");
        consulta.setData(2020, 12, 3, 16, 00);
        return consulta;
    }
}
