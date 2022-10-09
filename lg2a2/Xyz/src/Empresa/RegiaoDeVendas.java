package Empresa;

import java.util.ArrayList;

public class RegiaoDeVendas{

    final private String nomeRegiao;

    private double faturamento;

    private SetorVendas setorVendas;
    private RepresentanteDeVendas representante;

    private ArrayList<ZonaDeVendas> zonasDeVendas;

    public RegiaoDeVendas(String nomeRegiao, double faturamento) {
        this.nomeRegiao = nomeRegiao;
        this.faturamento = faturamento;
        zonasDeVendas = new ArrayList<>();
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public RepresentanteDeVendas getRepresentante() {
        return representante;
    }

    public SetorVendas getSetorVendas() {
        return setorVendas;
    }

    public void setSetorVendas(SetorVendas setorVendas) {
        this.setorVendas = setorVendas;
    }

    public void setRepresentante(RepresentanteDeVendas representante) {
        this.representante = representante;
    }

    public void adicionarZonaVendas(ZonaDeVendas zonaDeVendas){
        zonasDeVendas.add(zonaDeVendas);
    }

    public void removerZonaVendas(ZonaDeVendas zonaDeVendas){
        zonasDeVendas.remove(zonaDeVendas);
    }

    public int quantideZonaVendas(){
        return zonasDeVendas.size();
    }

    public ZonaDeVendas getZonaVendas(int posicao){
        return zonasDeVendas.get(posicao);
    }


}
