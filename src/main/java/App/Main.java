package App;

import Repository.Conexao;
import janela.FrmPrincipal;

public class Main {
    public static void main(String[] args) {

        FrmPrincipal frmPrincipal = new FrmPrincipal();
        try {

            Conexao.conectar();
            System.out.println("Banco aberto");

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
       }

}
