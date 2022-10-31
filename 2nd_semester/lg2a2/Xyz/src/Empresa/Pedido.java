package Empresa;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    final private String codigo;
    private ArrayList<Produto> produtos;
    Cliente cliente;

    public Pedido() {
        this.codigo = String.valueOf((new Date().getTime()));
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    public void removerProduto(Produto produto){
        produtos.remove(produto);
    }

    public int quantidadeProdutos(){
        return produtos.size();
    }

    public Produto getProdutos(int posicao){
        return produtos.get(posicao);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
