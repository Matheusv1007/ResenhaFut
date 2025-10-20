package Classes;

public class Pagamento {

    private String formaPagamento;
    private double valorPago;

    public Pagamento(String formaPagamento, double valorPago) {
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
