package visao;

import dao.ConexaoBanco;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FazerReservaVisao extends FormPadrao{

    JComboBox jcbModelos;
    JComboBox jcbVoos;
    JButton jbtnConf;
    JButton jbtnCanc;

    JLabel jlVoos;
    JLabel jlFileira;
    JLabel jlColuna;

    PreparedStatement stm = null;
    ResultSet rs = null;
    String sql;
    public FazerReservaVisao(){
        setTitle("Fazer Reserva");
    }

    @Override
    public void inicializarComponentes() {
        label1.setText("Nome");
        label2.setText("CPF");

        jlVoos = new JLabel("Escolha seu voo");
        jlVoos.setBounds(114,160,150,16);

        jcbVoos = new JComboBox();
        jcbVoos.setBounds(113, 180, 270, 30);

        jbtnConf = new JButton("Confirmar");
        jbtnConf.setBounds(113,280,110,35);

        jbtnCanc = new JButton("Cancelar");
        jbtnCanc.setBounds(280,280,110,35);


        updateComboVoos(jcbVoos);
        jbtnConf.addActionListener(e -> salvarVisao());
        jbtnCanc.addActionListener(e -> dispose());
        jpnFormulario.add(jlVoos);
        jpnFormulario.add(jcbVoos);
        jpnFormulario.add(jbtnConf);
        jpnFormulario.add(jbtnCanc);
    }

    @Override
    public void salvarVisao() {

    }
    private void updateComboVoos(JComboBox comboBox){
        comboBox.setEnabled(false);
        comboBox.removeAllItems();
        sql = "SELECT Id, data, hora, destino from Voos";
        try {
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            rs = stm.executeQuery();
            if (!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Não há voos cadastrados");
                jbtnConf.setEnabled(false);
                return;
            }
            comboBox.setEnabled(true);
            while (rs.next()){
                StringBuilder str = new StringBuilder();
                str.append(rs.getString("Id")).append(" - ")
                        .append(rs.getString("destino")).append(" - ")
                        .append(rs.getString("hora")).append(" - ")
                        .append(rs.getString("data"));
                comboBox.addItem(str);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
