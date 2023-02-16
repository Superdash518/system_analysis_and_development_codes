package br.edu.ifsp.xyz.comissao;

import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class Comissao {
    Vendedor vendedor;

    Data dataInicio;
    Data dataFim;
    ArrayList<Pedido> pedidos = new ArrayList<>();
    double comissao;

    public Comissao(String caminho, int chave, String valorChave, Data dataInicio, Data dataFim) throws Exception {
        this.vendedor = new Vendedor(caminho, chave, valorChave);

        String caminhoPedido = "./src/Pedido.txt";
        int chavePedido = 2;
        String valorChavePedido = vendedor.getMatricula();


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

    public Comissao(String caminho, int chave, String valorChave) throws Exception {
        this(caminho, chave, valorChave, new Data(1, 1, 1900), new Data(31, 12, 2099));
    }

    public void gerarRelatorio() {
        try {
        comissao = 0;
            Document documento = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(documento, Files.newOutputStream(Paths.get("./src/relatorio/relatorio" + Calendar.getInstance().getTimeInMillis() + ".pdf")));
            documento.open();

            PdfPTable table = new PdfPTable(8);
            PdfPCell cell = new PdfPCell(new Paragraph("Extrato de vendas - " + vendedor.getNome()));
            cell.setColspan(9);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);


            table.addCell(cell);
            table.addCell("Pedido");
            table.addCell("Data");
            table.addCell("Produto");
            table.addCell("Preco");
            table.addCell("Quantidade");
            table.addCell("Valor Total");
            table.addCell("Percentual");
            table.addCell("Valor comissao");

            for (Pedido pedido: pedidos) {
                for (int j = 0; j < pedido.getItensPedidos().length; j++) {
                    table.addCell(String.valueOf(pedido.getIdPedido()));
                    table.addCell(pedido.getDataPedido().toString());
                    table.addCell(pedido.getItensPedidos()[j].getProduto().getNome());
                    table.addCell(String.valueOf(pedido.getItensPedidos()[j].getPreco()));
                    table.addCell(String.valueOf(pedido.getItensPedidos()[j].getQuantidade()));
                    table.addCell(String.valueOf(pedido.getItensPedidos()[j].getValorTotalItem()));
                    table.addCell(String.valueOf(pedido.getItensPedidos()[j].getPercentualComissao()));
                    table.addCell(String.valueOf(pedido.getItensPedidos()[j].getComissaoPedido()));
                    comissao += pedido.getItensPedidos()[j].getComissaoPedido();
                }
            }
            cell = new PdfPCell(new Paragraph("Comissao: R$" + comissao));
            cell.setColspan(9);
            cell.setBackgroundColor(BaseColor.ORANGE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            documento.add(table);
            documento.close();

        } catch (DocumentException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public String toString() {
        comissao = 0;
        System.out.println("-------------------------------- Extrato de Vendas -----------------------------------------");
        System.out.println("Vendedor: " + vendedor.getNome());
        System.out.printf("|%-6s|%-10s|%-16s|%-6s|%10s|%11s|%10s|%14s|%n", "Pedido", "Data", "Produto",
                "Preco", "Quantidade", "Valor Total", "Percentual", "Valor Comissao");
        for (Pedido pedido : pedidos) {
            for (int j = 0; j < pedido.getItensPedidos().length; j++) {
                System.out.printf("|%-6d|%-10s|%-16s|%-6s|%10s|%11s|%10s|%14s|%n", pedido.getIdPedido(),
                        pedido.getDataPedido(),
                        pedido.getItensPedidos()[j].getProduto().getNome(),
                        pedido.getItensPedidos()[j].getPreco(),
                        pedido.getItensPedidos()[j].getQuantidade(),
                        pedido.getItensPedidos()[j].getValorTotalItem(),
                        pedido.getItensPedidos()[j].getPercentualComissao(),
                        pedido.getItensPedidos()[j].getComissaoPedido());
                comissao += pedido.getItensPedidos()[j].getComissaoPedido();
            }
        }
        System.out.println("Comissao Total: " + comissao);
        return "--------------------------------------------------------------------------------------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comissao comissao1 = (Comissao) o;
        return Double.compare(comissao1.comissao, comissao) == 0 && Objects.equals(vendedor, comissao1.vendedor) && Objects.equals(dataInicio, comissao1.dataInicio) && Objects.equals(dataFim, comissao1.dataFim) && Objects.equals(pedidos, comissao1.pedidos);
    }
}
