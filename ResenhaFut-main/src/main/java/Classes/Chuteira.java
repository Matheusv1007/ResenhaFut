package Classes;

public class Chuteira extends Produto{

    private String tamanho;
    private  String cor;
    private  String tipo;

    public Chuteira(String tamanho, String cor, String tipo) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
    }

    public Chuteira(String nome, String categoria, double preco, int quantidade, String marca, String tamanho, String cor, String tipo) {
        super(nome, categoria, preco, quantidade, marca);
        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
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
