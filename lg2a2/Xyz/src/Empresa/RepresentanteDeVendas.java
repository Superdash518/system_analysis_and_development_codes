package Empresa;

public class RepresentanteDeVendas extends Mercador {


    private RegiaoDeVendas regiaoDeVendas;
    public RepresentanteDeVendas(String nome, double valorVendas) {
        super(nome, valorVendas);
        //this.valorVendas = valorVendas;
    }

    public String getNome() {
        return super.getNome();

    }

    public RegiaoDeVendas getRegiaoDeVendas() {
        return regiaoDeVendas;
    }

    public void setRegiaoDeVendas(RegiaoDeVendas regiaoDeVendas) {
        this.regiaoDeVendas = regiaoDeVendas;
    }

    public double getValorVendas() {
        return super.getValorVendas();
    }

    public double getComissao() {
        return super.getComissao();
    }
}
