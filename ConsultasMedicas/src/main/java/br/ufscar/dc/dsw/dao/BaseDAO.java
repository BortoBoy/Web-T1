package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
    
abstract public class BaseDAO {
    public BaseDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
    	String url = "jdbc:mysql://localhost:3306/Login";
    	return DriverManager.getConnection(url, "dsw", "dsw123");
    }
}