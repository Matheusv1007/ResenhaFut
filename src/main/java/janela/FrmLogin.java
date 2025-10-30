package janela;

import Repository.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmLogin extends JInternalFrame {
    private JPanel panel1;
    private JLabel Login;
    private JFormattedTextField TextFieldEmail;
    private JPasswordField passwordSenha;
    private JButton cancelar;
    private JButton entrar;

    // Guardamos a referência da janela principal
    public FrmPrincipal principal;

    public FrmLogin(FrmPrincipal principal) {
        // Recebe a FrmPrincipal e a armazena
        this.principal = principal;

        setTitle("Login");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(480, 400);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setContentPane(panel1);
        this.setVisible(true);

        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica o login primeiro
                if (verificarLogin()) {

                    // AQUI ESTÁ A MUDANÇA:
                    // Chama o método na FrmPrincipal para ATUALIZAR OS MENUS
                    principal.gerenciarVisibilidadeMenus(true);

                    JOptionPane.showMessageDialog(FrmLogin.this, "Login realizado com sucesso!");
                    dispose(); // Fecha a janela de login
                }
                // Se o login falhar, o método verificarLogin() já mostrou o erro
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmLogin.this.dispose();
            }
        });
    }

    /**
     * Verifica o login e retorna true se for sucesso, false se falhar.
     * Mostra as mensagens de erro internamente.
     */
    private boolean verificarLogin() {
        String email = TextFieldEmail.getText();
        String senha = new String(passwordSenha.getPassword());

        if (email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return false;
        }

        if (checarBanco(email, senha)) {
            return true; // Sucesso
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha incorretos!");
            return false; // Falha
        }
    }

    private boolean checarBanco(String email, String senha) {
        boolean sucesso = false;
        String sql = "SELECT * FROM Cadastro WHERE email = ? AND senha = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, email);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro de banco de dados: " + e.getMessage());
        }

        return sucesso;
    }
}