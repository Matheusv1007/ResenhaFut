package Classes;

public class Chuteira extends Produto{

    private int tamanho;
    private  String cor;
    private  String tipo;

    public Chuteira(int tamanho, String cor, String tipo) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
    }

    public Chuteira(String nome,  double preco, int quantidade, String marca, int tamanho, String cor, String tipo, String tipoProduto) {
        super(nome, preco, quantidade, marca,tipoProduto);
        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void pesquisarChuteira() {

        System.out.println("Executando pesquisa por Chuteira.");
        System.out.println("Critérios: Marca=" + this.getMarca() + ", Tamanho=" + this.tamanho + ", Tipo=" + this.tipo);
    }
}
