package janela;

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

public class FrmLogin extends JInternalFrame {
    private JPanel painelPrincipal;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnCancelar;
    private JButton btnEntrar;

    // Guardamos a referência da janela principal
    public FrmPrincipal principal;

    public FrmLogin(FrmPrincipal principal) {
        // Recebe a FrmPrincipal e a armazena
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
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBackground(new Color(240, 240, 240));
        
        // Título
        JLabel lblTitulo = new JLabel("Login");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(180, 20, 100, 30);
        painelPrincipal.add(lblTitulo);
        
        // Label e campo Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 80, 100, 25);
        painelPrincipal.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 80, 250, 25);
        txtEmail.setToolTipText("Digite seu email");
        ((AbstractDocument) txtEmail.getDocument()).setDocumentFilter(new EmailFilter());
        painelPrincipal.add(txtEmail);
        
        // Label e campo Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 130, 100, 25);
        painelPrincipal.add(lblSenha);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(150, 130, 250, 25);
        painelPrincipal.add(txtSenha);
        
        // Botões
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(150, 190, 100, 30);
        btnEntrar.setBackground(new Color(0, 150, 0));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);
        painelPrincipal.add(btnEntrar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(260, 190, 100, 30);
        btnCancelar.setBackground(new Color(200, 200, 200));
        btnCancelar.setFocusPainted(false);
        painelPrincipal.add(btnCancelar);
        
        // Listeners
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica o login primeiro
                if (verificarLogin()) {
                    // Chama o método na FrmPrincipal para ATUALIZAR OS MENUS
                    principal.gerenciarVisibilidadeMenus(true);
                    JOptionPane.showMessageDialog(FrmLogin.this, "Login realizado com sucesso!");
                    dispose(); // Fecha a janela de login
                }
                // Se o login falhar, o método verificarLogin() já mostrou o erro
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmLogin.this.dispose();
            }
        });
        
        this.setContentPane(painelPrincipal);
    }

    /**
     * Verifica o login e retorna true se for sucesso, false se falhar.
     * Mostra as mensagens de erro internamente.
     */
    private boolean verificarLogin() {
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getPassword());

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
    
    // Filtro para email (permite letras, números, @, ., _, -)
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