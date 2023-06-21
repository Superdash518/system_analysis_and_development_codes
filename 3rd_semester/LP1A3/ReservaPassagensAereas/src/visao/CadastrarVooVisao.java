package visao;

import controle.CadastrarAviaoControle;
import controle.CadastrarVooControle;
import dao.ConexaoBanco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CadastrarVooVisao extends FormPadrao{
    JComboBox jcbModelos;
    JButton jbtnConf;
    JButton jbtnCanc;

    JLabel jlAvioes;
    public CadastrarVooVisao(){
        setTitle("Cadastrar Voo");
    }
    @Override
    public void inicializarComponentes() {
        label1.setText("Data");
        label2.setText("Hora");
        label3.setText("Destino");
        jlAvioes = new JLabel("Modelo");
        jlAvioes.setBounds(114,210,150,16);

        jcbModelos = new JComboBox();
        jcbModelos.setBounds(113, 230, 270, 30);

        jbtnConf = new JButton("Confirmar");
        jbtnConf.setBounds(113,280,110,35);

        jbtnCanc = new JButton("Cancelar");
        jbtnCanc.setBounds(280,280,110,35);

        jpnFormulario.add(jlAvioes);
        jpnFormulario.add(jbtnConf);
        jpnFormulario.add(jbtnCanc);
        updateCombo(jcbModelos);
        jpnFormulario.add(jcbModelos);


        jbtnConf.addActionListener(e -> salvarVisao());

        jbtnCanc.addActionListener(e -> dispose());

    }

    private void updateCombo(JComboBox comboBox){
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * from avioes";
        try {
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()){
                comboBox.addItem(rs.getString("Modelo"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Instância de controle
    CadastrarVooControle cvc = new CadastrarVooControle();
    @Override
    public void salvarVisao() {
        cvc.salvarControle(textField1.getText(), textField2.getText(), textField3.getText(), jcbModelos.getSelectedItem().toString());
    }

}
