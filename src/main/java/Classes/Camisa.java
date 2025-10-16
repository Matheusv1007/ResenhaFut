package Classes;

public class Camisa extends Produto{

    private String material;
    private  String TimeCamisa;
    private  String tamanho;

    public Camisa(String material, String timeCamisa, String tamanho) {
        this.material = material;
        this.TimeCamisa = timeCamisa;
        this.tamanho = tamanho;
    }

    public Camisa(String nome, String categoria, double preco, int quantidade, String marca, String material, String timeCamisa, String tamanho) {
        super(nome, categoria, preco, quantidade, marca);
        this.material = material;
        this.TimeCamisa = timeCamisa;
        this.tamanho = tamanho;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTimeCamisa() {
        return TimeCamisa;
    }

    public void setTimeCamisa(String timeCamisa) {
        TimeCamisa = timeCamisa;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}
