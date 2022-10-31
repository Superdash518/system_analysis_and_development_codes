package br.edu.ifsp.xyz.comissao;

import br.edu.ifsp.xyz.leitor.Leitor;

import java.util.ArrayList;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto(String caminho, int chave, String valorChave) throws Exception {
        Leitor leitor = new Leitor(caminho, chave, valorChave);
        ArrayList<String> produtos = leitor.conteudo();
        String produto = produtos.get(0);
        String[] campos = produto.split(";");
        this.id = Integer.parseInt(campos[0]);
        this.nome = campos[1];
        this.preco = Double.parseDouble(campos[2]);

        String caminhoCategoria = "./src/Categoria.txt";
        int chaveCategoria = 0;
        String valorChaveCategoria = campos[3];
        this.categoria = new Categoria(caminhoCategoria, chaveCategoria,valorChaveCategoria);

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco + " categoria= " + categoria.getNome() +
                '}';
    }
}
