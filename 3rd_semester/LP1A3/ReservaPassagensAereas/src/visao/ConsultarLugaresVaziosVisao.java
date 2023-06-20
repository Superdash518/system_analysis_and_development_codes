package visao;

import javax.swing.*;
import java.util.ArrayList;

public class ConsultarLugaresVaziosVisao extends FormPadrao{


    ArrayList<String> arr;

    @Override
    public void inicializarComponentes() {
        arr = new ArrayList<>();
        arr.add("Teste");
        arr.add("Teste 2");
        int pos_horizontal = 10;
        for (String palavra : arr) {
            JLabel label = new JLabel(palavra);
            label.setBounds(pos_horizontal,10,80,16);
            pos_horizontal+=80;
            jpnFormulario.add(label);
        }
    }

    @Override
    public void salvarVisao() {

    }
}
