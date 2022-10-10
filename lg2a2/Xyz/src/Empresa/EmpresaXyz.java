package Empresa;

import java.text.MessageFormat;

public class EmpresaXyz {

    final private String nome;
    final private String cnpj;

    //Seria um arraylist caso existissem mais setores

    SetorVendas vendas;

    public EmpresaXyz() {
        this.nome = "EmpresaXyz";
        this.cnpj = "16.127.610/0001-90";
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getVendas() {
        return vendas.getFaturamento();
    }

    public void setVendas(SetorVendas vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return MessageFormat.format("A empresa {0} possui o cnpj {1} e sua " +
                "área de vendas teve o faturamento de  {2}", getNome(),getCnpj(),getVendas());
    }
}
