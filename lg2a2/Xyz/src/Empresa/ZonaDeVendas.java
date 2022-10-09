package Empresa;

import java.util.Objects;

public class ZonaDeVendas{

    final private int id;
    final private String nomeZona;

    private RegiaoDeVendas regiao;
    private Vendedor vendedor;


    public ZonaDeVendas(int id, String nomeZona) {
        this.id = id;
        this.nomeZona = nomeZona;
    }

    public int getId() {
        return id;
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
    }

    public void setRegiao(RegiaoDeVendas regiao){
        this.regiao = regiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZonaDeVendas that = (ZonaDeVendas) o;
        return id == that.id && Objects.equals(nomeZona, that.nomeZona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeZona);
    }
}
