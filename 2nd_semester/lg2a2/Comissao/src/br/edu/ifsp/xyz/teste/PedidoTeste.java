package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Cliente;
import br.edu.ifsp.xyz.comissao.Pedido;
import br.edu.ifsp.xyz.comissao.Vendedor;

public class PedidoTeste {
	public static void main(String[] args) throws Exception {
	/*	Cliente cliente = new Cliente("./src/Cliente.txt", 0, "123");
		System.out.println("--->" + cliente);
*/
		Pedido pedido = new Pedido("./src/Pedido.txt", 0, "1");
		System.out.println("--->" + pedido);
/*
		Vendedor vendedor = new Vendedor("./src/Vendedor.txt", 0, "8000");
		System.out.println("--->" + vendedor);*/
	}

}
