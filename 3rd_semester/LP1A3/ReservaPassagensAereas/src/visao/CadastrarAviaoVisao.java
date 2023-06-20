package visao;

import controle.CadastrarAviaoControle;

import java.awt.*;

public class CadastrarAviaoVisao extends FormPadrao {

    public CadastrarAviaoVisao(){
        setTitle("Cadastrar Aeronave");
    }
    @Override
    public void inicializarComponentes() {
        label1.setText("Modelo da aeronave");
        label2.setText("Total de fileiras");
        label3.setText("Total de assentos por fileira");
    }

    //Instância de controle
    CadastrarAviaoControle cac = new CadastrarAviaoControle();

    @Override
    public void salvarVisao() {
        cac.salvarControle(textField1.getText(), textField2.getText(), textField3.getText());
    }


}
