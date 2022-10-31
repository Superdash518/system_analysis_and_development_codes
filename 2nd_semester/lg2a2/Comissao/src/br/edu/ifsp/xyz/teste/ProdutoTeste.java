package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Produto;

public class ProdutoTeste {
    public static void main(String[] args) throws Exception {
        Produto produto = new Produto("./src/Produto.txt", 0, "300");
        System.out.println("--->" + produto);
    }
}
