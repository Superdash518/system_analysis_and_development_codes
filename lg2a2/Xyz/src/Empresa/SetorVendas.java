package Empresa;

import java.util.ArrayList;

public class SetorVendas {

    private String unidade;
    private double faturamento;

    private ArrayList<RegiaoDeVendas> regioesDeVendas;


    public SetorVendas(String unidade) {
        this.unidade = unidade;
        regioesDeVendas = new ArrayList<RegiaoDeVendas>();
    }

    public String getUnidade() {
        return unidade;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void adicionarRegiaoVendas(RegiaoDeVendas regiaoDeVendas){
        regioesDeVendas.add(regiaoDeVendas);
        regiaoDeVendas.setSetorVendas(this);
    }

    public int quantidadeRegiaoVendas(){
        return regioesDeVendas.size();
    }

    public void excluirRegiaoVendas(RegiaoDeVendas regiaoDeVendas){
        regioesDeVendas.remove(regiaoDeVendas);
    }

    public RegiaoDeVendas getRegiaoVendas(int posicao){
        return regioesDeVendas.get(posicao);
    }
}
