package Classes;

public class Funcionario extends Pessoa{

    private String cargo;
    private double salario;

    public Funcionario(){
        super();
    }

    public Funcionario(String nome, String cpf, String email, int idade, int telefone, String cargo, double salario) {
        super(nome, cpf, email, idade, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void registrarVenda(Venda venda) {
        System.out.println("Venda registrada pelo funcionário: " + this.getNome());
    }
};