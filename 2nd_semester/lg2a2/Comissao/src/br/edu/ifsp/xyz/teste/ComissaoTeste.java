package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Comissao;
import br.edu.ifsp.xyz.util.Data;


public class ComissaoTeste {
    public static void main(String[] args) throws Exception {
        Comissao comissao = new Comissao("./src/Vendedor.txt", 0, "9000", new Data(1, 1, 2021), new Data(1, 12, 2022));
        comissao.gerarRelatorio();
        System.out.println(comissao);
    }
}
