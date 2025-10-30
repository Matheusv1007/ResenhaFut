package Classes;

public class Bola extends Produto{

    private String cor;
    private  String modelo;
    private String tipo;

    public Bola(String cor, String modelo, String tipo) {
        this.cor = cor;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public Bola(String nome, double preco, int quantidade, String marca, String cor, String modelo, String tipo, String tipoProduto) {
        super(nome, preco, quantidade, marca, tipoProduto);
        this.cor = cor;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void pesquisarBola() {

        System.out.println("Executando pesquisa por Bola.");
        System.out.println("Critérios: Modelo=" + this.modelo + ", Marca=" + this.getMarca() + ", Tipo=" + this.tipo);
    }
}
