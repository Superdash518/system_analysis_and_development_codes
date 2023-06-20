/*
 * Created by JFormDesigner on Mon Jun 19 12:10:30 BRT 2023
 */

package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Pablo
 */
public abstract class FormPadrao extends JInternalFrame {
    public abstract void inicializarComponentes();
    public abstract void salvarVisao();

    public FormPadrao() {
        initComponents();
        inicializarComponentes();
    }

    private void jbtnCancelarActionPerformed(ActionEvent e) {
        dispose();
    }

    private void jbtnConfirmarActionPerformed(ActionEvent e) {
       salvarVisao();
    }

    private void textField2KeyPressed(KeyEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Pablo Ribeiro
        jpnFormulario = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label2 = new JLabel();
        textField3 = new JTextField();
        label3 = new JLabel();
        jbtnConfirmar = new JButton();
        jbtnCancelar = new JButton();

        //======== this ========
        setVisible(true);
        var contentPane = getContentPane();

        //======== jpnFormulario ========
        {
            jpnFormulario. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //---- label1 ----
            label1.setText("text");

            //---- textField2 ----
            textField2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            textField2.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    textField2KeyPressed(e);
                }
            });

            //---- label2 ----
            label2.setText("text");

            //---- label3 ----
            label3.setText("text");

            //---- jbtnConfirmar ----
            jbtnConfirmar.setText("Confirmar");
            jbtnConfirmar.addActionListener(e -> jbtnConfirmarActionPerformed(e));

            //---- jbtnCancelar ----
            jbtnCancelar.setText("Cancelar");
            jbtnCancelar.addActionListener(e -> jbtnCancelarActionPerformed(e));

            GroupLayout jpnFormularioLayout = new GroupLayout(jpnFormulario);
            jpnFormulario.setLayout(jpnFormularioLayout);
            jpnFormularioLayout.setHorizontalGroup(
                jpnFormularioLayout.createParallelGroup()
                    .addGroup(jpnFormularioLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(jpnFormularioLayout.createParallelGroup()
                            .addGroup(jpnFormularioLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label2)
                            .addComponent(label1)
                            .addGroup(jpnFormularioLayout.createSequentialGroup()
                                .addComponent(jbtnConfirmar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jbtnCancelar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label3))
                        .addContainerGap(172, Short.MAX_VALUE))
            );
            jpnFormularioLayout.setVerticalGroup(
                jpnFormularioLayout.createParallelGroup()
                    .addGroup(jpnFormularioLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(label1)
                        .addGap(6, 6, 6)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label2)
                        .addGap(12, 12, 12)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jpnFormularioLayout.createParallelGroup()
                            .addComponent(jbtnConfirmar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnCancelar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(37, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(jpnFormulario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(jpnFormulario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Pablo Ribeiro
    protected JPanel jpnFormulario;
    protected JLabel label1;
    protected JTextField textField1;
    protected JTextField textField2;
    protected JLabel label2;
    protected JTextField textField3;
    protected JLabel label3;
    protected JButton jbtnConfirmar;
    protected JButton jbtnCancelar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

