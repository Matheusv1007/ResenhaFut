package janela;

import Classes.Cadastro;
import Repository.CadastroRepository;
import util.FormUtil;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrmCadastro extends JInternalFrame {
    private JPanel painelPrincipal;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtCpf;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnCadastrar;
    private JButton btnCancelar;

    public FrmCadastro() {
        this.setTitle("Cadastro de Cliente");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(480, 450);
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
        JLabel lblTitulo = new JLabel("Cadastro de Cliente");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(140, 10, 250, 30);
        painelPrincipal.add(lblTitulo);
        
        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 60, 100, 25);
        painelPrincipal.add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(150, 60, 300, 25);
        ((AbstractDocument) txtNome.getDocument()).setDocumentFilter(new LetrasEspacosFilter());
        painelPrincipal.add(txtNome);
        
        // Idade
        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(30, 100, 100, 25);
        painelPrincipal.add(lblIdade);
        
        txtIdade = new JTextField();
        txtIdade.setBounds(150, 100, 300, 25);
        txtIdade.setToolTipText("Digite apenas números");
        ((AbstractDocument) txtIdade.getDocument()).setDocumentFilter(new NumeroInteiroFilter());
        painelPrincipal.add(txtIdade);
        
        // CPF
        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(30, 140, 100, 25);
        painelPrincipal.add(lblCpf);
        
        txtCpf = new JTextField();
        txtCpf.setBounds(150, 140, 300, 25);
        txtCpf.setToolTipText("Digite apenas números");
        ((AbstractDocument) txtCpf.getDocument()).setDocumentFilter(new NumeroInteiroFilter());
        painelPrincipal.add(txtCpf);
        
        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 180, 100, 25);
        painelPrincipal.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 180, 300, 25);
        txtEmail.setToolTipText("Digite seu email");
        ((AbstractDocument) txtEmail.getDocument()).setDocumentFilter(new EmailFilter());
        painelPrincipal.add(txtEmail);
        
        // Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(30, 220, 100, 25);
        painelPrincipal.add(lblSenha);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(150, 220, 300, 25);
        painelPrincipal.add(txtSenha);
        
        // Botões
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(150, 280, 120, 30);
        btnCadastrar.setBackground(new Color(0, 150, 0));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        painelPrincipal.add(btnCadastrar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(280, 280, 120, 30);
        btnCancelar.setBackground(new Color(200, 200, 200));
        btnCancelar.setFocusPainted(false);
        painelPrincipal.add(btnCancelar);

        // Listeners
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCadastro.this.dispose();
            }
        });
        
        this.setContentPane(painelPrincipal);
    }
    
    private void cadastrarCliente() {
        // Declara um vetor com os campos de texto do formulário
        JTextField[] campos = {txtEmail, txtNome, txtCpf, txtIdade};

        // Pega a senha da forma correta
        String senha = new String(txtSenha.getPassword());

        // Verifica se campos de texto OU a senha estão vazios
        if (FormUtil.hasEmpty(campos) || senha.isEmpty()) {
            JOptionPane.showMessageDialog(FrmCadastro.this,
                    "Preencher todos os campos obrigatórios",
                    "Erro ao salvar",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            Cadastro pessoa = new Cadastro();
            pessoa.setSenha(senha);
            pessoa.setEmail(txtEmail.getText());
            try {
                pessoa.setIdade(Integer.parseInt(txtIdade.getText()));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(
                        FrmCadastro.this,
                        "Erro: A idade deve ser um número válido."
                );
                return;
            }
            pessoa.setNome(txtNome.getText());
            pessoa.setCpf(txtCpf.getText());

            try {
                CadastroRepository.inserir(pessoa);

                // Limpa os campos
                FormUtil.cleanJTexts(campos);
                txtSenha.setText("");

                JOptionPane.showMessageDialog(
                        FrmCadastro.this,
                        "Salvo com Sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                dispose(); // Fecha a janela de cadastro após sucesso

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        FrmCadastro.this,
                        "Erro ao inserir no banco: " + ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                ex.printStackTrace();
            }
        }
    }
    
    // Filtro para permitir apenas letras e espaços
    private class LetrasEspacosFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[a-zA-ZÀ-ÿ\\s]*")) {
                super.insertString(fb, offset, string, attr);
            }
        }
        
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[a-zA-ZÀ-ÿ\\s]*")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
    
    // Filtro para permitir apenas números inteiros
    private class NumeroInteiroFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[0-9]*")) {
                super.insertString(fb, offset, string, attr);
            }
        }
        
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[0-9]*")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
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
