package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Medico;
import java.util.List;

public class TestMedicoDAO {

    public static void main(String[] args) throws Exception {
        // Execute aqui suas ações de teste
        // medicoInsertion();
        // medicoDeletion();
        // medicoGetOne();
        // medicoGetAll();
        // medicoUpdate();
        
    }
    
    public static void medicoInsertion() throws Exception{
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = medicoGenerator();
        medicoDAO.insert(medico);
        System.out.println("[INFO] Medico inserido com sucesso");
    }
    
    public static void medicoDeletion() throws Exception{
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.delete("123123");
        System.out.println("[INFO] Medico deletado com sucesso");
    }
    
    public static void medicoUpdate() throws Exception{
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = medicoGenerator();
        medicoDAO.update(medico, "123123");
        System.out.println("[INFO] Medico atualizado com sucesso");
    }
    
    public static void medicoGetOne() throws Exception{
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = medicoDAO.getbyCrm("142342/BA");
        System.out.println("[INFO] Medico requisitado com sucesso");
        System.out.println(medico.toString());
    }
    
    public static void medicoGetAll() throws Exception{
        MedicoDAO medicoDAO = new MedicoDAO();
        List<Medico> medicos = medicoDAO.getAll();
        System.out.println("[INFO] Medicos requisitados com sucesso");
        for (Medico medico : medicos) {
            System.out.println(medico.toString());
        }
    }
    
    private static Medico medicoGenerator() throws Exception{
        Medico medico = new Medico();
        medico.setEmail("medico_teste_editado@gmail.com");
        medico.setSenha("senha4321");
        medico.setCrm("123123");
        medico.setNome("Nome Medico Teste");
        medico.setEspecialidade(0);
        return medico;
    }
}
