package dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
    private static final String driverClass = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/passagensdb";
    private static final String user = "root";
    private static final String password = "password";
    public static Connection abreConexao(){
        Connection con = null;

        try {
            Class.forName(driverClass);
            con = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + e);
        }
        return con;
    }
}
