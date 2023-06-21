/*
 * Created by JFormDesigner on Wed Jun 21 18:11:20 BRT 2023
 */

package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Pablo
 */
public abstract class FormPadraoConsulta extends JInternalFrame {
    public abstract void inicializarComponentes();
    public FormPadraoConsulta() {
        initComponents();
        inicializarComponentes();
    }

    private void textField2KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void jbtnConfirmarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jbtnCancelarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Pablo Ribeiro
        jpnFormulario = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setVisible(true);
        setClosable(true);
        var contentPane = getContentPane();

        //======== jpnFormulario ========
        {
            jpnFormulario.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
            EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing
            . border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,
            java . awt. Color .red ) ,jpnFormulario. getBorder () ) ); jpnFormulario. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
            { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )
            throw new RuntimeException( ) ;} } );

            //---- label1 ----
            label1.setText("text");

            //---- label2 ----
            label2.setText("text");
            label2.setFont(new Font("Segoe UI", Font.PLAIN, 36));

            GroupLayout jpnFormularioLayout = new GroupLayout(jpnFormulario);
            jpnFormulario.setLayout(jpnFormularioLayout);
            jpnFormularioLayout.setHorizontalGroup(
                jpnFormularioLayout.createParallelGroup()
                    .addGroup(jpnFormularioLayout.createSequentialGroup()
                        .addGroup(jpnFormularioLayout.createParallelGroup()
                            .addGroup(jpnFormularioLayout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(label1))
                            .addGroup(jpnFormularioLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(231, Short.MAX_VALUE))
            );
            jpnFormularioLayout.setVerticalGroup(
                jpnFormularioLayout.createParallelGroup()
                    .addGroup(jpnFormularioLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(label1)
                        .addGap(98, 98, 98)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(106, Short.MAX_VALUE))
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
    protected JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
