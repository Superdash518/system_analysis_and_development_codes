package controle;

import dao.CadastrarVooDao;
import interfaces.InterfaceControle;
import modelo.AeronaveModelo;
import modelo.CadastrarVooModelo;

import javax.swing.*;

public class CadastrarVooControle implements InterfaceControle {
    @Override
    public void salvarControle(Object... valor) {
        CadastrarVooModelo cvm = new CadastrarVooModelo();
        CadastrarVooDao cvd = new CadastrarVooDao();

        //  Verificando se os campos estão preenchidos
        for (Object value: valor) {
            if(value.equals("")){
                JOptionPane.showMessageDialog(null,"Preencha todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        cvm.setData(valor[0].toString());
        cvm.setHora(valor[1].toString());
        cvm.setDestino(valor[2].toString());
        cvm.setAeronave(new AeronaveModelo(valor[3].toString()));
        cvd.salvarDao(cvm);
    }
}
