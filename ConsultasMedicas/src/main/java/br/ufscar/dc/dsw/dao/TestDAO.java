package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Paciente;
import java.sql.Date;

public class TestDAO {

    public static void main(String[] args) throws Exception {
        // Execute aqui suas ações de teste
        pacienteUpdate();
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
        pacienteDAO.update(paciente);
        System.out.println("[INFO] Paciente atualizado com sucesso");
    }
    
    private static Paciente pacienteGenerator() throws Exception{
        Paciente paciente = new Paciente();
        paciente.setEmail("email_teste_editado@gmail.com");
        paciente.setSenha("senha123123");
        paciente.setCpf("354.812.448-44");
        paciente.setNome("Frederico testeiro da Silva");
        paciente.setTelefone("+5518996076736");
        paciente.setSexo(0);
        paciente.setAniversario(new Date(1998, 6, 4));
        return paciente;
    }
    
    //TODO restante dos testes
}
