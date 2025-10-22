package Classes;

public class Pagamento {
    private String tipodePagamento;
    private double valor;

    public Pagamento(String tipodePagamento, double valor) {
        this.tipodePagamento = tipodePagamento;
        this.valor = valor;
    }
    public boolean confirmarPagamento() {
        if (valor > 0) {
            System.out.println("Valor R$:" + valor + "Forma de pagamento" + tipodePagamento + "Pagamento Concluido!");
            return true;
        } else {
            System.out.println("Pagamento invalido!");
            return false;
        }
    }

    public String getTipodePagamento() {
        return tipodePagamento;
    }

    public void setTipodePagamento(String tipodePagamento) {
        this.tipodePagamento = tipodePagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}