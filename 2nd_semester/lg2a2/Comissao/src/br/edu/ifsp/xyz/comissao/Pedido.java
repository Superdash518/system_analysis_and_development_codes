package br.edu.ifsp.xyz.comissao;
import br.edu.ifsp.xyz.util.Data;

import java.util.ArrayList;
import java.util.Arrays;

import br.edu.ifsp.xyz.leitor.Leitor;

public class Pedido {
	private int idPedido;
	private String cpf;
	private Data dataPedido;
	private double valorTotal;
	private String nomeCliente;
	private String nomeVendedor;
	ItemPedido[] itensPedidos;

	public int getIdPedido() {
		return idPedido;
	}

	public String getCpf() {
		return cpf;
	}

	public Data getDataPedido() {
		return dataPedido;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	double getComissaoVendedor(){
		int i = 0;
		double valorComissao = 0;
		for (ItemPedido produto : itensPedidos) {
			valorComissao += (itensPedidos[i].getPreco() * itensPedidos[i].getQuantidade()) * (itensPedidos[i].getComissao() / 100);
			i++;
		}
		return valorComissao;
	}
	double getValorPedido(){
		int i = 0;
		Double[] valores = new Double[itensPedidos.length];
		double valor = 0;
		for (ItemPedido itemAux : itensPedidos) {
			valores[i] = itemAux.getPreco() * itemAux.getQuantidade();
			i++;
		}
		for (double preco : valores) {
			valor += preco;
		}
		return valor;
	}
	public Pedido(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> pedidos = leitor.conteudo();
		String pedido = pedidos.get(0);
		String[] campos = pedido.split(";");
        this.idPedido = Integer.parseInt(campos[0]);
        this.cpf = campos[1];
        String[] campoData = campos[3].split("/");
        int dia = Integer.parseInt(campoData[0]);
        int mes = Integer.parseInt(campoData[1]);
        int ano = Integer.parseInt(campoData[2]);
        this.dataPedido = new Data(dia,mes,ano);


		String caminhoCliente = "./src/Cliente.txt";
		int chaveCliente = 0;
		String valorChaveCliente = campos[1];
		leitor = new Leitor(caminhoCliente, chaveCliente, valorChaveCliente);
		ArrayList<String> clientes = leitor.conteudo();
		int indice = 0;
		for(String cliente: clientes){
			campos = clientes.get(indice).split(";");
			this.nomeCliente = campos[1];
		}

		String caminhoVendedor = "./src/Vendedor.txt";
		int chaveVendedor = 0;
		String valorChaveVendedor = campos[4];
		leitor = new Leitor(caminhoVendedor, chaveVendedor, valorChaveVendedor);
		ArrayList<String> vendedores = leitor.conteudo();
		for (String vendedor: vendedores){
			campos = vendedores.get(0).split(";");
			this.nomeVendedor = campos[1];
		}

		String caminhoItem = "./src/ItemPedido.txt";
		int chaveItem = 1;
		int valorChaveItem = this.idPedido;

		leitor = new Leitor(caminhoItem, chaveItem, String.valueOf(valorChaveItem));
		ArrayList<String> itens = leitor.conteudo();

		int qtItens = itens.size();
		this.itensPedidos = new ItemPedido[qtItens];
		int indiceItem = 0;
		for (String itemAux : itens) {
			campos = itens.get(indiceItem).split(";");
			chaveItem = 0;
			valorChaveItem = Integer.parseInt(campos[0]);

			ItemPedido itemPedido = new ItemPedido(caminhoItem, chaveItem, valorChaveItem);
			this.itensPedidos[indiceItem] = itemPedido;
			indiceItem+= 1;

		}
		this.valorTotal += getValorPedido();
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"idPedido=" + idPedido +
				", cpf='" + cpf + '\'' + ",Cliente=" + nomeCliente + ",Vendedor= " + nomeVendedor +
				", dataPedido=" + dataPedido +
				", valor total=" + valorTotal +
				", itensPedidos=" + Arrays.toString(itensPedidos) +
				'}';
	}


}
