package Empresa;

import Empresa.Cliente;

import java.util.ArrayList;

public class Vendedor extends Mercador {

     //lista de clientes cadastrados
    private ArrayList<Cliente> clientes;

    private ZonaDeVendas zonaDeVendas;
    private RegiaoDeVendas regiaoDeVendas;

    private double comissao;

    public Vendedor(String nome, ArrayList<Cliente> clientes, ZonaDeVendas zonaDeVendas, RegiaoDeVendas regiaoDeVendas) {
        super(nome);
        this.clientes = clientes;
        this.zonaDeVendas = zonaDeVendas;
        this.regiaoDeVendas = regiaoDeVendas;
    }

    public Vendedor(String nome) {
        super(nome);
        clientes = new ArrayList<Cliente>();
        //this.valorVendas = valorVendas;
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
        cliente.setVendedor(this);
    }

    public int quantidadeClientes(){
        return clientes.size();
    }

    public Cliente getCliente(int posicao){
        return clientes.get(posicao);
    }


    public String getNome() {
        return super.getNome();
    }

    public double getValorVendas() {
        return super.getValorVendas();
    }

    public double getComissao() {
        return super.getComissao();
    }

    public String getZonaDeVendas() {
        return zonaDeVendas.getNomeZona();
    }

    public String getRegiaoDeVendas() {
        return regiaoDeVendas.getNomeRegiao();
    }

    public void setZonaDeVendas(ZonaDeVendas zonaDeVendas) {
        this.zonaDeVendas = zonaDeVendas;
    }

    public void setRegiaoDeVendas(RegiaoDeVendas regiaoDeVendas) {
        this.regiaoDeVendas = regiaoDeVendas;
    }
}
