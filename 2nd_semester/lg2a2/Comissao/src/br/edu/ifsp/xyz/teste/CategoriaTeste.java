package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Categoria;

public class CategoriaTeste {
    public static void main(String[] args) throws Exception {
        Categoria categoria = new Categoria("./src/Categoria.txt", 0, "10");
        System.out.println("--->" + categoria);
    }
}
