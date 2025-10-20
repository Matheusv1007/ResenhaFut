package Classes;

public class Produto {

    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;
    private  String marca;

    public Produto(){

    }

    public Produto(String nome, String categoria, double preco, int quantidade, String marca) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public void adicionarProduto() {

        System.out.println("Lógica para adicionar o produto '" + this.nome + "' ao sistema.");
    }

    public void removerProduto() {

        System.out.println("Lógica para remover o produto '" + this.nome + "' do sistema.");
    }

    public void atualizarProduto() {

        System.out.println("Lógica para atualizar as informações do produto '" + this.nome + "'.");
    }

    public void atualizarEstoque(int novaQuantidade) {

        this.quantidade = novaQuantidade;
        System.out.println("Estoque do produto '" + this.nome + "' atualizado para: " + this.quantidade);
    }

    public boolean verificarDisponibilidade() {

        if (this.quantidade > 0) {

            System.out.println("Produto '" + this.nome + "' está disponível.");
            return true;
        } else {

            System.out.println("Produto '" + this.nome + "' está fora de estoque.");
            return false;
        }
    }


}
