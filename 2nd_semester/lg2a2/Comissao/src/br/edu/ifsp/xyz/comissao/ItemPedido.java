package br.edu.ifsp.xyz.comissao;

import br.edu.ifsp.xyz.leitor.Leitor;

import java.util.ArrayList;
import java.util.Objects;

public class ItemPedido {


    private int idPedido;
    private int idItemPedido;
    private double preco;
    private int quantidade;
    private Produto produto;
    private double percentualComissao;

    public ItemPedido(String caminho, int chave, int valorChavePedido, int valorChaveProduto) throws Exception{
        Leitor leitor = new Leitor(caminho, chave, String.valueOf(valorChavePedido));
        ArrayList<String> itens = leitor.conteudo();

        ArrayList<String> item = new ArrayList<>();
        for (String itensAux : itens) {
            if(itensAux.contains(String.valueOf(valorChaveProduto))){
                item.add(itensAux);
            }
        }
        String[] campos = item.get(0).split(";");

        this.idPedido = Integer.parseInt(campos[1]);
        this.quantidade = Integer.parseInt(campos[2]);
        this.idItemPedido = Integer.parseInt(campos[0]);

        String caminhoProduto = "./src/Produto.txt";
        int chaveProduto = 0;

        this.produto = new Produto(caminhoProduto, chaveProduto, String.valueOf(valorChaveProduto));
        this.preco = produto.getPreco();
        this.percentualComissao = produto.getCategoria().getPercentualComissao();
    }
    public ItemPedido(String caminho, int chave, int valorChave) throws Exception{
        Leitor leitor = new Leitor(caminho, chave, String.valueOf(valorChave));
        ArrayList<String> itens = leitor.conteudo();
        int count = 0;
        for (String item: itens) {
            System.out.println(itens.get(count));
            count++;
        }

        /*
        ArrayList<String> itensPedidos = leitor.conteudo();
        String itemPedido = itensPedidos.get(0);
        String[] campos = itemPedido.split(";");
        this.idPedido = Integer.parseInt(campos[1]);
        this.quantidade = Integer.parseInt(campos[2]);
        this.idItemPedido = Integer.parseInt(campos[0]);

        String caminhoProduto = "./src/Produto.txt";
        int chaveProduto = 0;
        String valorChaveProduto = campos[0];

        this.produto = new Produto(caminhoProduto, chaveProduto, valorChaveProduto);
        this.preco = produto.getPreco();
        this.comissao = produto.getCategoria().getPercentualComissao();
        /*
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
        }*/
    }

    public int getIdPedido() {
        return idPedido;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public Produto getProduto() {
        return produto;
    }
    public double getPreco() {
        return preco;
    }
    public double getPercentualComissao() {
        return percentualComissao;
    }
    public double getValorTotalItem(){
        return this.getPreco() * this.getQuantidade();
    }

    public double getComissaoPedido(){
        return this.getValorTotalItem() * (this.getPercentualComissao()/100);
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "idPedido=" + idPedido +
                ", idItemPedido=" + idItemPedido +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", produto=" + produto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return idPedido == that.idPedido && idItemPedido == that.idItemPedido && Double.compare(that.preco, preco) == 0 && quantidade == that.quantidade && Double.compare(that.percentualComissao, percentualComissao) == 0 && Objects.equals(produto, that.produto);
    }
}
