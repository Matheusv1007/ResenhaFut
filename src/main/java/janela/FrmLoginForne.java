package janela;

import Classes.Fornecedor;
import Repository.Conexao;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmLoginForne extends JInternalFrame {
    private JPanel PainelPrincipal;
    private JLabel Login;
    private JButton entrar;
    private JButton cancelar;
    private JTextField textEmail;
    private JPasswordField password;
    private JLabel Email;
    private JLabel senha;

    public FrmPrincipal principal;

    public FrmLoginForne(FrmPrincipal principal) {
        this.principal = principal;
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(450, 300);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true);

        inicializarComponentes();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        PainelPrincipal = new JPanel();
        PainelPrincipal.setLayout(null);
        PainelPrincipal.setBackground(new Color(240, 240, 240));


        JLabel lblTitulo = new JLabel("Login");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(180, 20, 100, 30);
        PainelPrincipal.add(lblTitulo);

        Email = new JLabel("Email:");
        Email.setBounds(50, 80, 100, 25);
        PainelPrincipal.add(Email);

        textEmail = new JFormattedTextField();
        textEmail.setBounds(150, 80, 250, 25);
        textEmail.setToolTipText("Digite seu email");
        ((AbstractDocument) textEmail.getDocument()).setDocumentFilter(new EmailFilter());
        PainelPrincipal.add(textEmail);

        senha = new JLabel("Senha:");
        senha.setBounds(50, 130, 100, 25);
        PainelPrincipal.add(senha);

        password = new JPasswordField();
        password.setBounds(150, 130, 250, 25);
        PainelPrincipal.add(password);

        entrar = new JButton("Entrar");
        entrar.setBounds(150, 190, 100, 30);
        entrar.setBackground(new Color(0, 150, 0));
        entrar.setForeground(Color.WHITE);
        entrar.setFocusPainted(false);
        PainelPrincipal.add(entrar);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(260, 190, 100, 30);
        cancelar.setBackground(new Color(200, 200, 200));
        cancelar.setFocusPainted(false);
        PainelPrincipal.add(cancelar);

        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verificarLogin()) {

                    principal.loginFornecedor();
                    JOptionPane.showMessageDialog(FrmLoginForne.this, "Login realizado com sucesso!");
                    dispose();
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.setContentPane(PainelPrincipal);
    }

    private boolean verificarLogin() {
        String email = textEmail.getText().trim().replaceAll("\\s+", "");
        String senha = new String(password.getPassword()).trim();

        if (email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return false;
        }

        boolean sucesso = checarBanco(email, senha);
        if (!sucesso) {
            JOptionPane.showMessageDialog(this, "Email ou senha incorretos!");
        }
        return sucesso;
    }


    private boolean checarBanco(String email, String senha) {
        boolean sucesso = false;
        String sql = "SELECT * FROM CadastroFornecedor WHERE email = ? AND senha = ? ";

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

    private class EmailFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[a-zA-Z0-9@._-]*")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[a-zA-Z0-9@._-]*")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
