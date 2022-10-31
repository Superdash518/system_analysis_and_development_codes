package br.edu.ifsp.xyz.comissao;

import br.edu.ifsp.xyz.leitor.Leitor;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemPedido {


    private int idPedido;
    private int idItemPedido;
    private double preco;
    private int quantidade;
    private Produto[] produtos;
    private double comissao;


    public ItemPedido(String caminho, int chave, int valorChave) throws Exception{
        Leitor leitor = new Leitor(caminho, chave, String.valueOf(valorChave));
        ArrayList<String> itensPedidos = leitor.conteudo();
        int indiceProduto = 0;

        int qtProdutos = itensPedidos.size();
        this.produtos = new Produto[qtProdutos];
        for (String itemPedido : itensPedidos) {
            String[] campos = itemPedido.split(";");
            this.idPedido = Integer.parseInt(campos[1]);
            this.quantidade = Integer.parseInt(campos[2]);
            this.idItemPedido = Integer.parseInt(campos[0]);

            String caminhoProduto = "./src/Produto.txt";
            int chaveProduto = 0;
            String valorChaveProduto = campos[0];
            Produto produto = new Produto(caminhoProduto, chaveProduto, valorChaveProduto);
            this.produtos[indiceProduto] = produto;
            this.preco = produtos[indiceProduto].getPreco();
            this.comissao = produtos[indiceProduto].getCategoria().getPercentualComissao();
            indiceProduto++;
        }
    }

    public int getIdPedido() {
        return idPedido;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public Produto[] getProduto() {
        return produtos;
    }
    public double getPreco() {
        return preco;
    }
    public double getComissao() {
        return comissao;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "idPedido=" + idPedido +
                ", idItemPedido=" + idItemPedido +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", produto=" + Arrays.toString(produtos) +
                '}';
    }
}
