package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufscar.dc.dsw.domain.Consulta;
import java.time.LocalDateTime;

public class ConsultaDAO extends BaseDAO {
    
    private String baseSQL;

    public ConsultaDAO() {
        super();
        this.baseSQL = "SELECT c.*, m.nome as nome_medico, "
        + "m.crm, m.especialidade, p.nome as nome_paciente, p.sexo, p.cpf from "
        + "Consulta c join Medico m on m.id = c.medico join Paciente p on "
        + "p.id = c.paciente";
    }
    
    public void insert(Consulta consulta) throws Exception {    
        // verifica se já não existe uma consulta nesse horario para esse paciente
        // ou esse paciente
        String sql = "select * from Consulta where ano=? and mes=? and dia=? and "
        + "hora=? and minuto=? and paciente = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, consulta.getAno());
            statement.setInt(2, consulta.getMes());
            statement.setInt(3, consulta.getDia());
            statement.setInt(4, consulta.getHora());
            statement.setInt(5, consulta.getMinuto());
            statement.setLong(6, consulta.getPaciente());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                throw new Exception("Esse paciente já tem uma consulta nesse horário");
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        // verifica se já não existe uma consulta nesse horario para esse medico
        // ou esse paciente
        sql = "select * from Consulta where ano=? and mes=? and dia=? and hora=?"
        + " and minuto=? and medico=?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, consulta.getAno());
            statement.setInt(2, consulta.getMes());
            statement.setInt(3, consulta.getDia());
            statement.setInt(4, consulta.getHora());
            statement.setInt(5, consulta.getMinuto());
            statement.setLong(6, consulta.getMedico());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                throw new Exception("Esse medico já tem uma consulta nesse horário");
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        //verifica se data é maior que a data atual
        LocalDateTime current = LocalDateTime.now();
        if(current.isAfter(LocalDateTime.of(consulta.getAno(), consulta.getMes(),
        consulta.getDia(), consulta.getHora(), consulta.getMinuto()))){
            throw new RuntimeException("Data para nova consulta deve ser maior que a data atual");
        }
        
        sql = "insert into Consulta(paciente, medico, dia, mes,"
        + " ano, hora, minuto) values(?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement;
            statement = conn.prepareStatement(sql);
            statement.setLong(1, consulta.getPaciente());
            statement.setLong(2, consulta.getMedico());
            statement.setInt(3, consulta.getDia());
            statement.setInt(4, consulta.getMes());
            statement.setInt(5, consulta.getAno());
            statement.setInt(6, consulta.getHora());
            statement.setInt(7, consulta.getMinuto());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(Long id) {
        String sql = "DELETE FROM Consulta where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public Consulta getOne(Long id) throws Exception {
        Consulta consulta = null;
        String sql = this.baseSQL + " where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                consulta = convertConsultaRowIntoConsultaObj(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consulta;
    }
    
    public ArrayList<Consulta> getbyPatient(Long id) throws Exception {
        
        String sql = this.baseSQL + " where c.paciente = ? order by c.ano desc, "
        + "c.mes desc, c.dia desc, c.hora desc, c.minuto desc";
        
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Consulta consulta = convertConsultaRowIntoConsultaObj(resultSet);
                listaConsultas.add(consulta);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsultas;
    }
    
    public ArrayList<Consulta> getbyMedico(Long id) throws Exception {
       
        String sql = this.baseSQL + " where c.medico = ? order by c.ano desc, c.mes desc, "
        + "c.dia desc, c.hora desc, c.minuto desc";
        
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Consulta consulta = convertConsultaRowIntoConsultaObj(resultSet);
                listaConsultas.add(consulta);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsultas;
    }

    private Consulta convertConsultaRowIntoConsultaObj(ResultSet resultSet) 
    throws SQLException, Exception {
        Consulta consulta = new Consulta();
        consulta.setId(resultSet.getLong("id"));
        consulta.setPaciente(resultSet.getLong("paciente"));
        consulta.setMedico(resultSet.getLong("medico"));
        consulta.setNome_medico(resultSet.getString("nome_medico"));
        consulta.setNome_paciente(resultSet.getString("nome_paciente"));
        consulta.setSexo_paciente(resultSet.getInt("sexo"));
        consulta.setEspecialidade_medico(resultSet.getInt("especialidade"));
        consulta.setCpf(resultSet.getString("cpf"));
        consulta.setCrm(resultSet.getString("crm"));
        int ano = resultSet.getInt("ano");
        int mes = resultSet.getInt("mes");
        int dia = resultSet.getInt("dia");
        int hora = resultSet.getInt("hora");
        int minuto = resultSet.getInt("minuto");
        consulta.setData(ano, mes, dia, hora, minuto);
        return consulta;
    }
}