package dao;

import controle.CadastrarAviaoControle;
import interfaces.InterfaceControle;
import interfaces.InterfaceDao;
import modelo.CadastrarAviaoModelo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastrarAviaoDao implements InterfaceDao {
    String sql;
    PreparedStatement stm;
    @Override
    public void salvarDao(Object... valor) {
        CadastrarAviaoModelo cac = (CadastrarAviaoModelo) valor[0];
        sql = "INSERT INTO avioes (modelo, total_fileiras,total_assentos) VALUES (?, ?, ?)";
        try{
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            stm.setString(1, cac.getModelo());
            stm.setInt(2,cac.getLugares().length);
            stm.setInt(3, cac.getLugares()[0].length);
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Registro Gravado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }
}
