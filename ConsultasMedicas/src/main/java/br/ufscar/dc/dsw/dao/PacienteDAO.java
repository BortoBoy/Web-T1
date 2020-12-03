package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.ufscar.dc.dsw.domain.Paciente;

public class PacienteDAO extends BaseDAO {

    public void insert(Paciente paciente) {    
        String sql = "insert into Paciente(email, senha, cpf, nome, telefone, "
        + "sexo, dia, mes, ano) values (?,?,?,?,?,?,?,?,?);";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement;
            statement = conn.prepareStatement(sql);
            statement.setString(1, paciente.getEmail());
            statement.setString(2, paciente.getSenha());
            statement.setString(3, paciente.getCpf());
            statement.setString(4, paciente.getNome());
            statement.setString(5, paciente.getTelefone());
            statement.setInt(6, paciente.getSexo());
            statement.setInt(7, paciente.getDia());
            statement.setInt(8, paciente.getMes());
            statement.setInt(9, paciente.getAno());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Paciente> getAll() throws Exception {   
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        String sql = "SELECT * from Paciente p";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // para cada paciente retornado pelo banco de dados crie um objeto
            // paciente usando os setters (pois esses contém as vaidações
            // necessárias
            while (resultSet.next()) {
                Paciente paciente = convertPacienteRowIntoPacienteObj(resultSet);
                listaPacientes.add(paciente);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }
    
    public void delete(String cpf) {
        String sql = "DELETE FROM Paciente where cpf = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Paciente paciente, String cpf) {
        String sql = "UPDATE Paciente SET email = ?, senha = ? , nome = ?, "
        + "cpf = ?, dia = ?, mes = ?, ano = ?, sexo = ?, telefone = ? WHERE cpf = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, paciente.getEmail());
            statement.setString(2, paciente.getSenha());
            statement.setString(3, paciente.getNome());
            statement.setString(4, paciente.getCpf());
            statement.setInt(5, paciente.getDia());
            statement.setInt(6, paciente.getMes());
            statement.setInt(7, paciente.getAno());
            statement.setInt(8, paciente.getSexo());
            statement.setString(9, paciente.getTelefone());
            statement.setString(10, cpf);
            System.out.println(statement);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Paciente getbyCpf(String cpf) throws Exception {
        Paciente paciente = null;
        String sql = "SELECT * from Paciente WHERE cpf = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                paciente = convertPacienteRowIntoPacienteObj(resultSet);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }

    private Paciente convertPacienteRowIntoPacienteObj(ResultSet resultSet)
    throws SQLException, Exception {
        Paciente paciente = new Paciente();
        paciente.setEmail(resultSet.getString("email"));
        paciente.setSenha(resultSet.getString("senha"));
        paciente.setCpf(resultSet.getString("cpf"));
        paciente.setNome(resultSet.getString("nome"));
        paciente.setTelefone(resultSet.getString("telefone"));
        paciente.setSexo(resultSet.getInt("sexo"));
        paciente.setAniversario(resultSet.getInt("dia"),
        resultSet.getInt("mes"),
        resultSet.getInt("ano"));
        
        return paciente;
    }
}