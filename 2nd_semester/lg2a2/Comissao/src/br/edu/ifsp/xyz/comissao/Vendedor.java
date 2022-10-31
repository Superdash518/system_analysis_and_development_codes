package br.edu.ifsp.xyz.comissao;

import br.edu.ifsp.xyz.leitor.Leitor;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Vendedor {

    String matricula;
    String nome;
    String telefone;

    double valorComissao;
    private Cliente[] clientes;

    double getValorComissao(Cliente cliente){
       Pedido[] pedidos = cliente.getPedidos();
       double comissao = 0;
        for (Pedido pedido : pedidos) {
            comissao += pedido.getComissaoVendedor();
        }
        return comissao;
    }
    public Vendedor(String caminho, int chave, String valorChave) throws Exception{
        Leitor leitor =  new Leitor(caminho, chave, valorChave);
        ArrayList<String> vendedores = leitor.conteudo();
        String vendedor = vendedores.get(0);
        String[] campos = vendedor.split(";");
        this.matricula = campos[0];
        this.nome = campos[1];
        this.telefone = campos[2];



        String caminhoCliente = "./src/Cliente.txt";
        int chaveCliente = 4;
        String valorChaveCliente = this.matricula;


        leitor = new Leitor(caminhoCliente, chaveCliente, valorChaveCliente);
        ArrayList<String> clientes = leitor.conteudo();

        int qtClientes = clientes.size();
        this.clientes = new Cliente[qtClientes];
        int indiceCliente = 0;
        for (String ignored : clientes) {
            campos = clientes.get(indiceCliente).split(";");
            chaveCliente = 0;
            valorChaveCliente = campos[0];
            Cliente cliente = new Cliente(caminhoCliente, chaveCliente, valorChaveCliente);
            this.clientes[indiceCliente] = cliente;
            indiceCliente++;

            valorComissao += getValorComissao(cliente);
        }
        }

       /* String caminhoPedido = "./src/Vendedor.txt";
        int chaveVendedor = 0;*/

        String getClientes(){
            String[] nomes = new String[clientes.length];
            int i = 0;
            for (Cliente cliente: clientes) {
                nomes[i] = cliente.getNome();
                i++;
            }
            return Arrays.toString(nomes);
        }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getValorComissao() {
        return valorComissao;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Vendedor Matricula= {0} nome = {1} telefone = {2} comissao = R${3} clientes={4} "
                , matricula, nome, telefone, valorComissao, Arrays.toString(clientes));
            /*"Vendedor{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", clientes=" + '\n' + for(Cliente cliente: clientes){cliente.getNome()} +
                '}';*/
    }
}
