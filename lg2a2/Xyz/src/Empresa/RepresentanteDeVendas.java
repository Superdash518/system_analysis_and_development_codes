package Empresa;

public class RepresentanteDeVendas extends Mercador {


    private RegiaoDeVendas regiaoDeVendas;
    public RepresentanteDeVendas(String nome) {
        super(nome);
        //this.valorVendas = valorVendas;
    }

    public String getNome() {
        return super.getNome();

    }

    public String getRegiaoDeVendas() {
        return regiaoDeVendas.getNomeRegiao();
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
