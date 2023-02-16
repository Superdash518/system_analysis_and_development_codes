package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Cliente;
import br.edu.ifsp.xyz.comissao.Pedido;
import br.edu.ifsp.xyz.comissao.Vendedor;

public class PedidoTeste {
	public static void main(String[] args) throws Exception {

		Pedido pedido = new Pedido("./src/Pedido.txt", 0, "2");
		System.out.println("--->" + pedido);
	}

}
