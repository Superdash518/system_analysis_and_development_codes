package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Cliente;
import br.edu.ifsp.xyz.comissao.ItemPedido;

public class ItemPedidoTeste {
    public static void main(String[] args) throws Exception {
        ItemPedido itemPedido = new ItemPedido("./src/ItemPedido.txt", 1, 1);
        System.out.println("--->" + itemPedido);
    }
}
