package Classes;

public class Cadastro {

    private String senha;
    private String email;
    private String nome;
    private int idade;
    private String cpf;

    public Cadastro(){

    }

    public Cadastro(String senha, String email, String nome, int idade, String cpf) {
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
