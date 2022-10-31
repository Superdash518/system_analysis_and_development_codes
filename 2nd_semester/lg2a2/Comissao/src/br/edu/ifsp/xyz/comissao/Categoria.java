package br.edu.ifsp.xyz.comissao;

import br.edu.ifsp.xyz.leitor.Leitor;

import java.util.ArrayList;

public class Categoria {

    private int id;
    private String nome;
    private double percentualComissao;

    public Categoria(String caminho, int chave, String valorChave) throws Exception {
        Leitor leitor = new Leitor(caminho, chave, valorChave);
        String categoria = leitor.conteudo().get(0);
        String[] campos = categoria.split(";");
        this.id = Integer.parseInt(campos[0]);
        this.nome = campos[1];
        this.percentualComissao = Double.parseDouble(campos[2]);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", percentualComissao=" + percentualComissao + "%" +
                '}';
    }
}
