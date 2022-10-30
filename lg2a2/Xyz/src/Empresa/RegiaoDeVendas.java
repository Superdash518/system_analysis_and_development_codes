package Empresa;

import java.util.ArrayList;

public class RegiaoDeVendas{

    final private String nomeRegiao;

    private double faturamento;

    private SetorVendas setorVendas;
    private RepresentanteDeVendas representante;

    private ArrayList<ZonaDeVendas> zonasDeVendas;


    public RegiaoDeVendas(String nomeRegiao, RepresentanteDeVendas representante) {
        this.nomeRegiao = nomeRegiao;
        zonasDeVendas = new ArrayList<>();
        this.representante = representante;
    }
    public RegiaoDeVendas(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
        zonasDeVendas = new ArrayList<>();
    }



    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public String getRepresentante() {
        return representante.getNome();
    }

    public String getUnidadeSetorVendas() {
        return setorVendas.getUnidade();
    }

    public void setSetorVendas(SetorVendas setorVendas) {
        this.setorVendas = setorVendas;
    }

    public void setRepresentante(RepresentanteDeVendas representante) {
        this.representante = representante;
        representante.setRegiaoDeVendas(this);
        representante.setZonasDeVendas(this.zonasDeVendas);
    }

    public void adicionarZonaVendas(ZonaDeVendas zonaDeVendas){
        zonasDeVendas.add(zonaDeVendas);
        zonaDeVendas.setRegiao(this);
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
