package janela;

import Repository.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmLogin extends JInternalFrame{
    private JPanel panel1;
    private JLabel Login;
    private JFormattedTextField TextFieldEmail;
    private JPasswordField passwordSenha;
    private JButton cancelar;
    private JButton entrar;
    public FrmPrincipal principal;

    public FrmLogin(FrmPrincipal principal){
        this.principal = principal;

        setTitle("Login");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(480,400);
        this.setResizable(false);
        this.setClosable(true);
        this.setResizable(true);
        this.setResizable(false);
        this.setIconifiable(true);
        this.setContentPane(panel1);
        this.setVisible(true);


        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarLogin();
                JOptionPane.showMessageDialog(FrmLogin.this, "Login realizado com sucesso!");
                principal.esconder();
                dispose();

            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmLogin.this.dispose();
            }
        });
    }

    private void verificarLogin(){
        String email = TextFieldEmail.getText();
        String senha = new String(passwordSenha.getPassword());

        if (email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        if (checarBanco(email, senha)) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            // abrir próxima janela
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha incorretos!");
        }

    }

    private boolean checarBanco(String email, String senha){
        boolean sucesso = false;
        String sql = "Select * From Cadastro WHERE email = ? AND senha = ?";

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
        }

        return sucesso;
    }

}
