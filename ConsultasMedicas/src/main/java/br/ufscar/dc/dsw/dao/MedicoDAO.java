package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Medico;

public class MedicoDAO extends BaseDAO {

    public void insert(Medico medico) {    
        String sql = "insert into Medico(email, senha, crm, nome, especialidade)"
        + " values(?, ?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement;
            statement = conn.prepareStatement(sql);
            statement.setString(1, medico.getEmail());
            statement.setString(2, medico.getSenha());
            statement.setString(3, medico.getCrm());
            statement.setString(4, medico.getNome());
            statement.setInt(5, medico.getEspecialidade());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Medico> getAll() throws Exception {   
        List<Medico> listaMedicos = new ArrayList<>();
        String sql = "SELECT * from Medico m";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // para cada medico retornado pelo banco de dados crie um objeto
            // medico usando os setters (pois esses contém as vaidações
            // necessárias
            while (resultSet.next()) {
                Medico medico = convertMedicoRowIntoMedicoObj(resultSet);
                listaMedicos.add(medico);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaMedicos;
    }
    
    public void delete(String crm) {
        String sql = "DELETE FROM Medico where crm = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, crm);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Medico medico) {
        String sql = "UPDATE Medico SET email = ?, senha = ? , nome = ?, "
        + "crm = ?, especialidade = ? WHERE crm = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, medico.getEmail());
            statement.setString(2, medico.getSenha());
            statement.setString(3, medico.getNome());
            statement.setString(4, medico.getCrm());
            statement.setInt(5, medico.getEspecialidade());
            statement.setString(6, medico.getCrm());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Medico getbyCpf(String crm) throws Exception {
        Medico medico = null;
        String sql = "SELECT * from Medico WHERE crm = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, crm);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                medico = convertMedicoRowIntoMedicoObj(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medico;
    }

    private Medico convertMedicoRowIntoMedicoObj(ResultSet resultSet) throws SQLException, Exception {
        Medico medico = new Medico();
        medico.setEmail(resultSet.getString("email"));
        medico.setSenha(resultSet.getString("senha"));
        medico.setNome(resultSet.getString("nome"));
        medico.setCrm(resultSet.getString("crm"));
        medico.setEspecialidade(resultSet.getInt("especialidade"));
        return medico;
    }
}