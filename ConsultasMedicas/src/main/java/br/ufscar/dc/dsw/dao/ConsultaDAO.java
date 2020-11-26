package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Consulta;

public class ConsultaDAO extends BaseDAO {

    public void insert(Consulta consulta) {    
        String sql = "insert into Medico(cpf_paciente, crm_medico, hora)"
        + " values(?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement;
            statement = conn.prepareStatement(sql);
            statement.setString(1, consulta.getCpf_paciente());
            statement.setString(2, consulta.getCrm_medico());
            statement.setDate(3, consulta.getHora());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Consulta> getAll() throws Exception {   
        List<Consulta> listaConsultas = new ArrayList<>();
        String sql = "SELECT * from Consulta c";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // para cada consulta retornada pelo banco de dados crie um objeto
            // consulta usando os setters (pois esses contém as vaidações
            // necessárias)
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
    
    public void update(Consulta consulta) {
        String sql = "UPDATE Consulta SET cpf_paciente = ?, crm_medico = ? , "
        + "hora = ? WHERE id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, consulta.getCpf_paciente());
            statement.setString(2, consulta.getCrm_medico());
            statement.setDate(3, consulta.getHora());
            statement.setLong(4, consulta.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Consulta getbyId(Long id) throws Exception {
        Consulta consulta = null;
        String sql = "SELECT * from Consulta WHERE id = ?";
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

    private Consulta convertConsultaRowIntoConsultaObj(ResultSet resultSet) 
    throws SQLException, Exception {
        Consulta consulta = new Consulta();
        consulta.setCpf_paciente(resultSet.getString("cpf_paciente"));
        consulta.setCrm_medico(resultSet.getString("crm_medico"));
        consulta.setId(resultSet.getLong("id"));
        consulta.setHora(resultSet.getDate("hora"));
        return consulta;
    }
}