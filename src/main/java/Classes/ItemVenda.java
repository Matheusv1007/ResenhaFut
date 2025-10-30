package Classes;

public class ItemVenda {
    private String nomeProduto;
    private double preco;
    private int quantidade;

    public ItemVenda(String nomeProduto, int quantidade, double preco) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public double calcularTotal(){
        return preco * quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}