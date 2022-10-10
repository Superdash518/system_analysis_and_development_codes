package Empresa;

public class TestJava {
    public static void main(String[] args) {

        EmpresaXyz empresaXyz = new EmpresaXyz();
        SetorVendas vendas = new SetorVendas("Matriz");

        RegiaoDeVendas regiaoNordeste = new RegiaoDeVendas("Nordeste");
        RegiaoDeVendas regiaoSudeste = new RegiaoDeVendas("Sudeste");

        RepresentanteDeVendas representante1 = new RepresentanteDeVendas("Paulo");
        RepresentanteDeVendas representante2 = new RepresentanteDeVendas("Carlos");

        ZonaDeVendas bahia = new ZonaDeVendas( "Bahia");
        ZonaDeVendas ceara = new ZonaDeVendas( "Ceará");
        ZonaDeVendas saoPaulo = new ZonaDeVendas( "São Paulo");
        ZonaDeVendas rioDeJaneiro = new ZonaDeVendas( "Rio de Janeiro");

        Vendedor vendedor1 = new Vendedor("Pablito");
        Vendedor vendedor2 = new Vendedor("Carlitos");
        Vendedor vendedor3 = new Vendedor("Juanito");
        Vendedor vendedor4 = new Vendedor("Dieguito");

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


        vendedor1.adicionarCliente(otavio);



      //  System.out.println(vendedor1.getZonaDeVendas());
        //vendedor1.setZonaDeVendas(bahia);


        /*

        vendedor3.adicionarCliente(otavio);

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

