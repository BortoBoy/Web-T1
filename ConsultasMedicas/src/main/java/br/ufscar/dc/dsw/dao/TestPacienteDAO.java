package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Paciente;
import java.sql.Date;
import java.util.List;

public class TestPacienteDAO {

    public static void main(String[] args) throws Exception {
        // Execute aqui suas ações de teste
    }
    
    public static void pacienteInsertion() throws Exception{
        PacienteDAO pacienteDAO = new PacienteDAO();
        Paciente paciente = pacienteGenerator();
        pacienteDAO.insert(paciente);
        System.out.println("[INFO] Paciente inserido com sucesso");
    }
    
    public static void pacienteDeletion() throws Exception{
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.delete("354.812.448-44");
        System.out.println("[INFO] Paciente deletado com sucesso");
    }
    
    public static void pacienteUpdate() throws Exception{
        PacienteDAO pacienteDAO = new PacienteDAO();
        Paciente paciente = pacienteGenerator();
        pacienteDAO.update(paciente, "123123");
        System.out.println("[INFO] Paciente atualizado com sucesso");
    }
    
    public static void pacienteGetOne() throws Exception{
        PacienteDAO pacienteDAO = new PacienteDAO();
        Paciente paciente = pacienteDAO.getbyCpf("123.123.123-12");
        System.out.println("[INFO] Paciente requisitado com sucesso");
        System.out.println(paciente.toString());
    }
    
    public static void pacienteGetAll() throws Exception{
        PacienteDAO pacienteDAO = new PacienteDAO();
        List<Paciente> pacientes = pacienteDAO.getAll();
        System.out.println("[INFO] Pacientes requisitados com sucesso");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.toString());
        }
    }
    
    private static Paciente pacienteGenerator() throws Exception{
        Paciente paciente = new Paciente();
        paciente.setEmail("email_teste_editado@gmail.com");
        paciente.setSenha("senha123123");
        paciente.setCpf("354.812.448-44");
        paciente.setNome("Frederico testeiro da Silva");
        paciente.setTelefone("+5518996076736");
        paciente.setSexo(0);
        paciente.setAniversario(0, 0, 0);
        return paciente;
    }
}
