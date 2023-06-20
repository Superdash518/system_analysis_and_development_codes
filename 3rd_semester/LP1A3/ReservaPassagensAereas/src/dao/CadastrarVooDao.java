package dao;

import interfaces.InterfaceDao;
import modelo.CadastrarAviaoModelo;
import modelo.CadastrarVooModelo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastrarVooDao implements InterfaceDao {

    String sql;
    PreparedStatement stm;


    @Override
    public void salvarDao(Object... valor) {
        CadastrarVooModelo cvm = (CadastrarVooModelo) valor[0];
        sql = "INSERT INTO voos (data, hora, destino, modelo) VALUES (?, ?, ?, ?)";
        try{
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            stm.setString(1, cvm.getData());
            stm.setString(2,cvm.getHora());
            stm.setString(3, cvm.getDestino());
            stm.setString(4, cvm.getAeronave().getModelo());
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Registro Gravado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }
}
