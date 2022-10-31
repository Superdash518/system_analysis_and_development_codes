package br.edu.ifsp.xyz.comissao;

import java.util.ArrayList;
import java.util.Arrays;

import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;

public class Cliente {
	private String cpf;
	private String nome;
	private Pedido[] pedidos;
	private Data dataCadastro;
	private String sexo;
	private String nomeVendedor;

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Cliente(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> clientes = leitor.conteudo();
		String cliente = clientes.get(0);
		//System.out.println("o cliente é o: " + cliente);
		String[] campos = cliente.split(";");
		this.cpf = campos[0];
		this.nome = campos[1];
		String[] campoData = campos[2].split("/");
		int dia = Integer.parseInt(campoData[0]);
		int mes = Integer.parseInt(campoData[1]);
		int ano = Integer.parseInt(campoData[2]);
		this.dataCadastro = new Data(dia, mes, ano);
		this.sexo = campos[3];

		//this.vendedor = campos[2];

		String caminhoPedido = "./src/Pedido.txt";
        int chavePedido = 1;
        String valorChavePedido = this.cpf;
		leitor = new Leitor(caminhoPedido, chavePedido, valorChavePedido);
		ArrayList<String> pedidos = leitor.conteudo();

		String caminhoVendedor = "./src/Vendedor.txt";
		int chaveVendedor = 0;
		String valorChaveVendedor = campos[4];
		leitor = new Leitor(caminhoVendedor, chaveVendedor, valorChaveVendedor);
		ArrayList<String> vendedores = leitor.conteudo();
		int indice = 0;
		for(String vendedor: vendedores){
			campos = clientes.get(indice).split(";");
			this.nomeVendedor = campos[1];
		}

		int qtPedidos = pedidos.size();
		this.pedidos = new Pedido[qtPedidos]; 
		int indicePedido = 0;
		for (String pedidoAux : pedidos) {
			campos = pedidos.get(indicePedido).split(";");
			chavePedido = 0;
			valorChavePedido = campos[0];
			Pedido pedido = new Pedido(caminhoPedido, chavePedido, valorChavePedido);
			this.pedidos[indicePedido] = pedido;
			indicePedido++;

			/*
			 campos = pedidoAux.split(";");
			 int idPedido = Integer.parseInt(campos[0]);
		     String cpf = campos[1];
		     String[] campoData = campos[3].split("/");
		     int dia = Integer.parseInt(campoData[0]);
		     int mes = Integer.parseInt(campoData[1]);
		     int ano = Integer.parseInt(campoData[2]);
		     Data dataPedido = new Data(dia,mes,ano);
		     double valor = Double.parseDouble(campos[4]);
		     Pedido pedido = new Pedido(idPedido,cpf,dataPedido,valor);
		     this.pedidos[indicePedido] = pedido;
		     indicePedido =+ 1;
		     */
		}

	}

	@Override
	public String toString() {
		return "Cliente{" +
				"cpf='" + cpf + '\'' +
				", nome='" + nome + '\'' +
				", pedidos=" + Arrays.toString(pedidos) +
				", dataCadastro=" + dataCadastro +
				", sexo='" + sexo + '\'' +
				", vendedor=" + nomeVendedor +
				'}';
	}
//		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", pedidos=" + Arrays.toString(pedidos) + "]";
	//return "Cliente [cpf=" + cpf + ", nome=" + nome + ", pedidos=" + getPedido() + "]";

}
