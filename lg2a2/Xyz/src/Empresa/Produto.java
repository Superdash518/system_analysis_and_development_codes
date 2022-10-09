package Empresa;

public class Produto{

    private String nome;
    private String categoria;
    private double preco;
    double porcentagemComissao;

    public Produto(String nome, String categoria) {
        this.nome = nome;
        this.categoria = definirCategoria(categoria);
        this.porcentagemComissao = definirComissao(categoria);
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPorcentagemComissao() {
        return porcentagemComissao;
    }

    public String definirCategoria(String categoria){
        if(categoria.equalsIgnoreCase("pelucias") || categoria.equalsIgnoreCase("brinquedos")){
            return categoria;
        }
        else{
            throw new RuntimeException("Categoria invalida!");
        }
    }
    public double definirComissao(String categoria){
        if(categoria.equalsIgnoreCase("pelucias")){
            return 3.0;
        }
        else {
            return 2.0;
        }
    }


}
