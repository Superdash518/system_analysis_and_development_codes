package Empresa;

import Empresa.Cliente;

import java.util.ArrayList;

public class Vendedor extends Mercador {

     //lista de clientes cadastrados
    private ArrayList<Cliente> clientes;

    private ZonaDeVendas zonaDeVendas;
    private RegiaoDeVendas regiaoDeVendas;

    public Vendedor(String nome, double valorVendas, ArrayList<Cliente> clientes, ZonaDeVendas zonaDeVendas, RegiaoDeVendas regiaoDeVendas) {
        super(nome, valorVendas);
        this.clientes = clientes;
        this.zonaDeVendas = zonaDeVendas;
        this.regiaoDeVendas = regiaoDeVendas;
    }

    public Vendedor(String nome, double valorVendas) {
        super(nome, valorVendas);
        clientes = new ArrayList<Cliente>();
        //this.valorVendas = valorVendas;
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
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

    public RegiaoDeVendas getRegiaoDeVendas() {
        return regiaoDeVendas;
    }

    public void setZonaDeVendas(ZonaDeVendas zonaDeVendas) {
        this.zonaDeVendas = zonaDeVendas;
    }

    public void setRegiaoDeVendas(RegiaoDeVendas regiaoDeVendas) {
        this.regiaoDeVendas = regiaoDeVendas;
    }
}
