package controle;

import dao.CadastrarAviaoDao;
import interfaces.InterfaceControle;
import modelo.CadastrarAviaoModelo;
import modelo.PassageiroModelo;

import javax.swing.*;

public class CadastrarAviaoControle implements InterfaceControle {
    CadastrarAviaoModelo cam = new CadastrarAviaoModelo();
    CadastrarAviaoDao cad = new CadastrarAviaoDao();

    @Override
    public void salvarControle(Object... valor) {
        //  Verificando se os campos estão preenchidos
        for (Object value: valor) {
            if(value.equals("")){
                JOptionPane.showMessageDialog(null,"Preencha todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        cam.setModelo(valor[0].toString());

            try {
                if(!isNumeric(valor[1].toString())){
                    JOptionPane.showMessageDialog(null, valor[1] + " Não é válido", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                if(!isNumeric(valor[2].toString())){
                    JOptionPane.showMessageDialog(null, valor[2] + " Não é válido", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            cam.setLugares(Integer.parseInt((String) valor[1]), Integer.parseInt((String) valor[2]));
            cad.salvarDao(cam);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
