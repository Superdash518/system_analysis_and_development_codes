package Empresa;

public abstract class Mercador {
    private String nome;
    private double valorVendas;
    private double comissao;

    public Mercador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getValorVendas() {
        return valorVendas;

    }

    public double getComissao() {
        return comissao;
    }

    @Override
    public String toString() {
        return "Mercador{" +
                "nome='" + nome + '\'' +
                ", valorVendas=" + valorVendas +
                ", comissao=" + comissao +
                '}';
    }
}
