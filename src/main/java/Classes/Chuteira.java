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

    public Chuteira(String nome,  double preco, int quantidade, String marca, String tamanho, String cor, String tipo, String tipoProduto) {
        super(nome, preco, quantidade, marca,tipoProduto);
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
}
