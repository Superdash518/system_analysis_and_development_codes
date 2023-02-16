package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.ComprasCliente;
import br.edu.ifsp.xyz.util.Data;

public class ComprasClienteTeste {
    public static void main(String[] args) throws Exception{
        ComprasCliente comprasCliente = new ComprasCliente("./src/Cliente.txt", 0, "255", new Data(1, 1,2021), new Data(1,4,2022));
        System.out.println(comprasCliente);
    }
}
