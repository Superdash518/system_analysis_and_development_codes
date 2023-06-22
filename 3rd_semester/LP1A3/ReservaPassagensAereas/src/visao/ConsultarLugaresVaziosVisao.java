package visao;

import dao.ConexaoBanco;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConsultarLugaresVaziosVisao extends FormPadraoConsulta{
    ArrayList<String> lugaresIndisponiveis = new ArrayList<>();
    JTable table;

    JScrollPane scrollPane;
    DefaultTableModel modelo;
    JComboBox jcbVoos;
    JLabel jlMensagem;

    PreparedStatement stm = null;
    ResultSet rs = null;
    String sql;
   // ImageIcon cadeiraReservada = new ImageIcon(new ImageIcon(getClass().getResource("/img/chair.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
   // ImageIcon cadeiraDisponivel = new ImageIcon(new ImageIcon(getClass().getResource("/img/seat-belt.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
    public ConsultarLugaresVaziosVisao(){
        setTitle("Consultar lugares vazios");
    }
    @Override
    public void inicializarComponentes() {

        label1.setText("Escolha o voo que deseja consultar");

        jcbVoos = new JComboBox();
        jcbVoos.setBounds(113, 50, 270, 30);
        jlMensagem = new JLabel("A quantidade de assentos disponíveis nesse voo é");
        jlMensagem.setBounds(108,90,300,25);
        jlMensagem.setVisible(false);

        table = new JTable();

        scrollPane = new JScrollPane();
        scrollPane.setBounds(0,200,490,150);
        scrollPane.setViewportView(table);
        modelo = (DefaultTableModel) table.getModel();

        updateComboVoos(jcbVoos);
        jpnFormulario.add(jcbVoos);
        jpnFormulario.add(jlMensagem);
        jpnFormulario.add(scrollPane);

        jcbVoos.addActionListener(e -> readJTable());
        jcbVoos.addActionListener(e -> updateLabel(label2));

    }
    private void updateLabel(JLabel label){
        sql = "SELECT avioes.Modelo, avioes.total_fileiras, avioes.total_assentos FROM voos JOIN avioes ON voos.modelo = avioes.modelo WHERE voos.Id = ?";
        try {
            int totalFileiras = 0;
            int totalColunas = 0;
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(jcbVoos.getSelectedItem().toString().substring(0, 1)));
            rs = stm.executeQuery();
            if (rs.next()){
                 totalFileiras = rs.getInt("total_fileiras");
                 totalColunas = rs.getInt("total_assentos");
            }

            boolean[][] lugaresDisponiveis = new boolean[totalFileiras][totalColunas];

            for (int i = 0; i < totalFileiras; i++) {
                for (int j = 0; j < totalColunas; j++) {
                    lugaresDisponiveis[i][j] = true; // Todos os lugares são inicialmente disponíveis
                }
            }

            for (String lugarIndisponivel : lugaresIndisponiveis) {
                marcarLugarIndisponivel(lugaresDisponiveis, lugarIndisponivel);
            }
            int qtdLugaresDisponiveis = 0;
            for (int i = 0; i < totalFileiras; i++) {
                for (int j = 0; j < totalColunas; j++) {
                    if (lugaresDisponiveis[i][j]) {
                        qtdLugaresDisponiveis++;
                    }
                }
            }
        jlMensagem.setVisible(true);
        label.setText(String.valueOf(qtdLugaresDisponiveis));
        label.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }
    public void readJTable() {
        sql = "SELECT avioes.Modelo, avioes.total_fileiras, avioes.total_assentos FROM voos JOIN avioes ON voos.modelo = avioes.modelo WHERE voos.Id = ?";
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        try {
            int totalFileiras = 0;
            int totalColunas = 0;
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(jcbVoos.getSelectedItem().toString().substring(0, 1)));
            rs = stm.executeQuery();
            if (rs.next()) {
                totalFileiras = rs.getInt("total_fileiras");
                totalColunas = rs.getInt("total_assentos");
            }

            boolean[][] lugaresDisponiveis = new boolean[totalFileiras][totalColunas];
            modelo.addColumn("Assentos disponíveis");

            for (int i = 0; i < totalFileiras; i++) {
                for (int j = 0; j < totalColunas; j++) {
                    lugaresDisponiveis[i][j] = true; // Todos os lugares são inicialmente disponíveis
                }
            }

            for (String lugarIndisponivel : lugaresIndisponiveis) {
                marcarLugarIndisponivel(lugaresDisponiveis, lugarIndisponivel);
            }

            for (int i = 0; i < totalFileiras; i++) {
                StringBuilder assentosIndisponiveis = new StringBuilder();
                for (int j = 0; j < totalColunas; j++) {
                    if (lugaresDisponiveis[i][j]) {
                        char letraColuna = (char) ('A' + j);
                        String numeroAssento = String.valueOf(i + 1) + letraColuna;
                        if (assentosIndisponiveis.length() > 0) {
                            assentosIndisponiveis.append(", ");
                        }
                        assentosIndisponiveis.append(numeroAssento);
                    }
                }
                if (assentosIndisponiveis.length() > 0) {
                    Object[] rowData = {assentosIndisponiveis.toString()};
                    modelo.addRow(rowData);
                }
            }

            // Adiciona a tabela à janela

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void marcarLugarIndisponivel(boolean[][] lugaresDisponiveis, String lugar) {
        int fileira = Integer.parseInt(lugar.substring(0, lugar.length() - 1)); // Extrair o número da fileira
        char coluna = lugar.charAt(lugar.length() - 1); // Extrair a letra da coluna

        int indiceFileira = fileira - 1; // Ajustar o índice da fileira (começando de 0)
        int indiceColuna = coluna - 'A'; // Ajustar o índice da coluna usando a tabela ASCII
        lugaresDisponiveis[indiceFileira][indiceColuna] = false;
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
            comboBox.setSelectedItem(null);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
