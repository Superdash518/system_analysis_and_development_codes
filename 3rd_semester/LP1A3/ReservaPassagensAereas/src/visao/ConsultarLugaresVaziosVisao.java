package visao;

import dao.ConexaoBanco;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultarLugaresVaziosVisao extends FormPadraoConsulta{
    ArrayList<Boolean> arr;

    JComboBox jcbVoos;
    JLabel label;

    PreparedStatement stm = null;
    ResultSet rs = null;
    String sql;
    ImageIcon cadeiraReservada = new ImageIcon(new ImageIcon(getClass().getResource("/img/chair.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
    ImageIcon cadeiraDisponivel = new ImageIcon(new ImageIcon(getClass().getResource("/img/seat-belt.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
    public ConsultarLugaresVaziosVisao(){
        setTitle("Consultar lugares vazios");
    }
    @Override
    public void inicializarComponentes() {

        label1.setText("Escolha o voo que deseja consultar");

        jcbVoos = new JComboBox();
        jcbVoos.setBounds(113, 50, 270, 30);

        updateComboVoos(jcbVoos);
        jpnFormulario.add(jcbVoos);

        jcbVoos.addActionListener(e -> updateLabel(label2));



//        JScrollPane scrollFrame = new JScrollPane(jpnFormulario);
//        jpnFormulario.setAutoscrolls(true);
//        scrollFrame.setPreferredSize(new Dimension( 342,300));
//        this.add(scrollFrame);
        /*JTextArea jTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(jpnFormulario);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 30, 300, 50);
        arr = new ArrayList<>();
        arr.add(false);
        arr.add(true);
        arr.add(true);
        arr.add(false);
        int pos_horizontal = 10;
        int pos_vertical = 10;
        for (Boolean bool : arr) {
            JButton button = new JButton();
            button.setBounds(pos_horizontal,10,30,30);
            if (bool){
                System.out.println("entrou 1");
                button.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/seat-belt(1).png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
            }
            else {
                System.out.println("2");
                button.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/seat-belt.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
            }
            pos_horizontal+=300;
            pos_vertical+=400;
            jpnFormulario.add(button);
        }
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,300));
        contentPane.add(scrollPane);

        jpnFormulario.scrollRectToVisible(jpnFormulario.getBounds());
        jTextArea.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        scrollPane.setViewportView(jpnFormulario);
        scrollPane.setBounds(30,30,180,180);
       // jpnFormulario.add(scrollPane);
    /*    button = new JButton();
        button.setBounds(150,150,30,30);
        button.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/chair.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
        button.setFocusable(false);
        jpnFormulario.add(button);*/
    }
    private void updateLabel(JLabel label){
        sql = "SELECT Modelo FROM voos JOIN avioes ON voos.modelo = avioes.modelo WHERE voos.Id = 1";
        try{
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
          // stm.setString(1, jcbVoos.getSelectedItem().toString().substring(0,1));
            rs = stm.executeQuery();
            System.out.println(rs);
        }catch (Exception e){

        }

    }
    private void updateComboVoos(JComboBox comboBox){
        sql = "SELECT avioes.Modelo FROM voos JOIN avioes ON voos.modelo = avioes.modelo WHERE voos.Id = 1";
        try{
         stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            rs = stm.executeQuery();
            if (!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Não há voos cadastrados");
                return;
            }
            System.out.println(rs);
            System.out.println(rs.getString("avioes.Modelo"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /*
        comboBox.setEnabled(false);
        comboBox.removeAllItems();
        sql = "SELECT Id, data, hora, destino from Voos";
        try {
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            rs = stm.executeQuery();
            if (!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Não há voos cadastrados");
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
        }*/
    }
}
