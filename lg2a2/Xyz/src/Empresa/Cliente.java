package Empresa;

import java.util.ArrayList;

public class Cliente {

    final private String cpf;
    private String nome;
    private String uf;

    private ZonaDeVendas zonaDeVendas;

    private RegiaoDeVendas regiaoDeVendas;
    private Vendedor vendedor;
    private ArrayList<Pedido> pedidos;

    public Cliente(String cpf, String nome, String uf) {
        this.cpf = cpf;
        this.nome = nome;
        this.uf = uf;
        pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Produto produto){
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(produto);
        pedidos.add(pedido);
        pedido.setCliente(this);
    }

    public void cancelarPedido(Pedido pedido){
        pedidos.remove(pedido);
    }

    public int quantidadePedidos(){
        return pedidos.size();
    }

    public Pedido getpedido(int posicao){
        return pedidos.get(posicao);
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getRegiao(){return "a";}

    //public String getZona()

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }
}
