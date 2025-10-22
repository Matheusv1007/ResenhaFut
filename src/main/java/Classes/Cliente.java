package Classes;

import java.util.LinkedList;

public class Cliente extends Pessoa
{
    private LinkedList<Venda> HistoricoDeCompras;
    
    public Cliente() {
        super();
        this.HistoricoDeCompras = new LinkedList<Venda>();
    }
    
    public Cliente(String nome, String cpf, String email, int idade, int telefone) {
        super(nome, cpf, email, idade, telefone);
        this.HistoricoDeCompras = new LinkedList<Venda>();
    }

    public LinkedList<Venda> getHistoricoDeCompras() {
        return HistoricoDeCompras;
    }
    
    public void setHistoricoDeCompras(LinkedList<Venda> historicoDeCompras) {
        this.HistoricoDeCompras = historicoDeCompras;
    }
    public void adicionarCompra(Venda venda) {
        HistoricoDeCompras.add(venda);
    }
    
    public void listarCompra() {
        for (Venda venda : HistoricoDeCompras) {
            System.out.println("Data da venda: " + venda.getDataVenda());
        }
    }
}