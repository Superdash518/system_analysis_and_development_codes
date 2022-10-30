package Empresa;

import java.util.Objects;

public class ZonaDeVendas{

    final private String nomeZona;

    private RegiaoDeVendas regiao;
    private Vendedor vendedor;


    public ZonaDeVendas(String nomeZona) {;
        this.nomeZona = nomeZona;
    }



    public String getNomeZona() {
        return nomeZona;
    }

    public String getNomeRegiao(){return regiao.getNomeRegiao();}
    public String getNomeVendedor() {
        return vendedor.getNome();
    }


    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        this.vendedor.setZonaDeVendas(this);
        this.vendedor.setRegiaoDeVendas(this.regiao);
    }

    public void setRegiao(RegiaoDeVendas regiao){
        this.regiao = regiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZonaDeVendas that = (ZonaDeVendas) o;
        return Objects.equals(nomeZona, that.nomeZona) && Objects.equals(regiao, that.regiao) && Objects.equals(vendedor, that.vendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeZona, regiao, vendedor);
    }
}
