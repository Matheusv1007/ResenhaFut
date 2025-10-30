package Classes;

import java.util.Date;
import java.util.List;

public class Venda {
    private Date dataVenda;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda(Date dataVenda, List<ItemVenda> itens, Pagamento pagamento) {
        this.dataVenda = dataVenda;
        this.itens = itens;
        this.pagamento = pagamento;
    }
    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public void removerItem(ItemVenda item) {
        itens.remove(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }

    public boolean finalizarVenda() {
        if (pagamento.confirmarPagamento()) {
            System.out.println("Venda Concluída, Obrigado!");
            return true;
        } else {
            System.out.println("Falha no pagamento. Venda não sucessedida.");
            return false;
        }
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
