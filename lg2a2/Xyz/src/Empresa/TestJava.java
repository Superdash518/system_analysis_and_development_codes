package Empresa;

public class TestJava {
    public static void main(String[] args) {

        EmpresaXyz empresaXyz = new EmpresaXyz();
        SetorVendas vendas = new SetorVendas("Matriz",1000000);

        RegiaoDeVendas regiaoNordeste = new RegiaoDeVendas("Nordeste", 500000);
        RegiaoDeVendas regiaoSudeste = new RegiaoDeVendas("Sudeste", 100000);

        RepresentanteDeVendas representante1 = new RepresentanteDeVendas("Paulo", 10000);
        RepresentanteDeVendas representante2 = new RepresentanteDeVendas("Carlos", 40000);

        ZonaDeVendas bahia = new ZonaDeVendas(1, "Bahia");
        ZonaDeVendas ceara = new ZonaDeVendas(2, "Ceará");
        ZonaDeVendas saoPaulo = new ZonaDeVendas(3, "São Paulo");
        ZonaDeVendas rioDeJaneiro = new ZonaDeVendas(4, "Rio de Janeiro");

        Vendedor vendedor1 = new Vendedor("Pablito", 80000);
        Vendedor vendedor2 = new Vendedor("Carlitos", 90000);
        Vendedor vendedor3 = new Vendedor("Juanito", 750348);
        Vendedor vendedor4 = new Vendedor("Dieguito", 2345678);

        Cliente otavio = new Cliente("866.307.070-52", "Otavio", "SP");

        Produto produto1 = new Produto("Rei chikita", "Pelucias");
        Produto produto2 = new Produto("Sr. Cabeça de batata", "Brinquedos");


        //Definindo área de vendas
        empresaXyz.setVendas(vendas);

        //Relacionando as regioes de vendas ao setor de vendas
        vendas.adicionarRegiaoVendas(regiaoNordeste);
        vendas.adicionarRegiaoVendas(regiaoSudeste);

        System.out.println(regiaoNordeste.getUnidadeSetorVendas());

        //Relacionando os representantes de vendas às regioes de vendas
        regiaoNordeste.setRepresentante(representante1);
        regiaoSudeste.setRepresentante(representante2);

        System.out.println(representante1);

        //Relacionando as zonas de vendas às regioes de vendas
        regiaoNordeste.adicionarZonaVendas(bahia);
        regiaoNordeste.adicionarZonaVendas(ceara);
        regiaoSudeste.adicionarZonaVendas(saoPaulo);
        regiaoSudeste.adicionarZonaVendas(rioDeJaneiro);

        //System.out.println(ceara.getNomeRegiao());

        //Relacionando vendedores às zonas de vendas
        bahia.setVendedor(vendedor1);
        ceara.setVendedor(vendedor2);
        saoPaulo.setVendedor(vendedor3);
        rioDeJaneiro.setVendedor(vendedor4);


      //  System.out.println(vendedor1.getZonaDeVendas());
        //vendedor1.setZonaDeVendas(bahia);


        /*

        vendedor3.adicionarCliente(otavio);
        otavio.setVendedor(vendedor3);

        vendedor3.setRegiaoDeVendas(regiaoSudeste);
        vendedor3.setZonaDeVendas(saoPaulo);

        otavio.adicionarPedido(produto1);

        */
      /*  System.out.println("O cliente " + otavio.getNome() + " é do uf " + otavio.getUf()
        + " e está na região " + otavio.getVendedor());

        for(int i = 0; i < regiaoNordeste.quantideZonaVendas(); i++){
            System.out.println("O vendedor " + regiaoNordeste.getZonaVendas(i).getVendedor().getNome() + " está na regiao " + regiaoNordeste.getZonaVendas(i).getVendedor().getRegiaoDeVendas());
        }
*/
    }

}

