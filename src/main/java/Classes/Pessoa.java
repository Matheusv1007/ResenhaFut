package Classes;

public abstract class  Pessoa {

    private String nome;
    private String Cpf;
    private String email;
    private int idade;
    private int telefone;

    public Pessoa(){

    }
    public Pessoa(String nome, String cpf, String email, int idade, int telefone) {
        this.nome = nome;
        Cpf = cpf;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + Cpf);
        System.out.println("Email: " + email);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: " + telefone);
    }
}