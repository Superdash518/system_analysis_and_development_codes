package br.edu.ifsp.xyz.comissao;

import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;

import java.util.ArrayList;

public class ComprasCliente {
    Cliente cliente;

    Data dataInicio;
    Data dataFim;
    ArrayList<Pedido> pedidos = new ArrayList<>();

    public ComprasCliente(String caminho, int chave, String valorChave, Data dataInicio, Data dataFim) throws Exception {
        this.cliente = new Cliente(caminho, chave, valorChave);

        String caminhoPedido = "./src/Pedido.txt";
        int chavePedido = 1;
        String valorChavePedido = cliente.getCpf();


        Leitor leitor = new Leitor(caminhoPedido, chavePedido, valorChavePedido);
        ArrayList<String> pedidosAux = leitor.conteudo();


        for (String aux : pedidosAux) {
            String[] campos = aux.split(";");
            chavePedido = 0;
            valorChavePedido = campos[0];
            Pedido pedido = new Pedido(caminhoPedido, chavePedido, valorChavePedido);
            //filtrando pedidos por data
            if (pedido.getDataPedido().between(dataInicio, dataFim)) {
                pedidos.add(pedido);
            }
        }
    }

    public ComprasCliente(String caminho, int chave, String valorChave) throws Exception {
        this(caminho, chave, valorChave, new Data(1, 1, 1900), new Data(31, 12, 2099));
    }

    @Override
    public String toString() {
        System.out.println("-------------------------------- Extrato de Vendas -----------------------------------------");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.printf("|%-6s|%-10s|%-16s|%-6s|%10s|%11s|%n", "Pedido", "Data", "Produto",
                "Preco", "Quantidade", "Valor Total");
        for (Pedido pedido : pedidos) {
            for (int j = 0; j < pedido.getItensPedidos().length; j++) {
                System.out.printf("|%-6d|%-10s|%-16s|%-6s|%10s|%11s|%n", pedido.getIdPedido(),
                        pedido.getDataPedido(),
                        pedido.getItensPedidos()[j].getProduto().getNome(),
                        pedido.getItensPedidos()[j].getPreco(),
                        pedido.getItensPedidos()[j].getQuantidade(),
                        pedido.getItensPedidos()[j].getValorTotalItem());
            }
        }
        return "--------------------------------------------------------------------------------------------";
    }
}
