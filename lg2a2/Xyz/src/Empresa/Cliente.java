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
        this.zonaDeVendas = setZonaDeVendas(uf);
        this.regiaoDeVendas = setRegiaoDeVendas(uf);
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

    public String getVendedor() {
        return vendedor.getNome();
    }

    public String getRegiao(){return regiaoDeVendas.getNomeRegiao();}

    public String getZona(){
        return zonaDeVendas.getNomeZona();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    protected void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public RegiaoDeVendas setRegiaoDeVendas(String uf){
        String nomeRegiao;
        switch (uf.toUpperCase()){
            case "BA":
            case "CE":
                nomeRegiao = "Nordeste";
                break;
            case "SP":
            case "RJ":
                nomeRegiao = "Sudeste";
                break;
            default:
                throw new RuntimeException("Insira uma UF cadastrada no sistema!");
        }

        return new RegiaoDeVendas(nomeRegiao);
    }

    private ZonaDeVendas setZonaDeVendas(String uf){
        String regiao;
        switch (uf.toUpperCase()){
            case "BA":
                regiao = "Bahia";
                break;
            case "CE":
                regiao = "Ceará";
                break;
            case "SP":
                regiao = "São Paulo";
                break;
            case "RJ":
                regiao = "Rio de Janeiro";
                break;
            default:
                throw new RuntimeException("Insira uma UF cadastrada no sistema!");
        }

        return new ZonaDeVendas(regiao);
    }

}
