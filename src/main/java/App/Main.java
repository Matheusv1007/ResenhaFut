package App;

import Repository.Conexao;
import janela.FrmPrincipal;

public class Main {
    public static void main(String[] args) {

        FrmPrincipal frmPrincipal = new FrmPrincipal();
        try {
            // Abre a conexão e cria as tabelas
            Conexao.conectar();
            System.out.println("Banco aberto e tabelas criadas com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao abrir o banco: " + e.getMessage());
        }
       }

}
