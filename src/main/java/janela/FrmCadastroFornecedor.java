package janela;

import Classes.Fornecedor;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class FrmCadastroFornecedor extends JInternalFrame {
    private JPanel painelPrincipal;
    private JTextField txtNome;
    private JFormattedTextField txtCnpj;
    private JFormattedTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtEndereco;
    private JTextField txtCidade;
    private JTextField txtEstado;
    private JPasswordField txtSenha;
    private JButton btnCadastrar;
    private JButton btnLimpar;

    public FrmCadastroFornecedor() {
        this.setTitle("Cadastro de Fornecedor");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 490);
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
        
        JLabel lblTitulo = new JLabel("Cadastro de Fornecedor");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(130, 10, 250, 30);
        painelPrincipal.add(lblTitulo);
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 60, 100, 25);
        painelPrincipal.add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(150, 60, 300, 25);
        painelPrincipal.add(txtNome);
        
        JLabel lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(30, 100, 100, 25);
        painelPrincipal.add(lblCnpj);
        
        try {
            MaskFormatter maskCnpj = new MaskFormatter("##.###.###/####-##");
            maskCnpj.setPlaceholderCharacter('_');
            txtCnpj = new JFormattedTextField(maskCnpj);
        } catch (ParseException e) {
            txtCnpj = new JFormattedTextField();
        }
        txtCnpj.setBounds(150, 100, 300, 25);
        painelPrincipal.add(txtCnpj);
        
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(30, 140, 100, 25);
        painelPrincipal.add(lblTelefone);
        
        try {
            MaskFormatter maskTelefone = new MaskFormatter("(##) #####-####");
            maskTelefone.setPlaceholderCharacter('_');
            txtTelefone = new JFormattedTextField(maskTelefone);
        } catch (ParseException e) {
            txtTelefone = new JFormattedTextField();
        }
        txtTelefone.setBounds(150, 140, 300, 25);
        painelPrincipal.add(txtTelefone);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 180, 100, 25);
        painelPrincipal.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 180, 300, 25);
        painelPrincipal.add(txtEmail);
        
        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(30, 220, 100, 25);
        painelPrincipal.add(lblEndereco);
        
        txtEndereco = new JTextField();
        txtEndereco.setBounds(150, 220, 300, 25);
        painelPrincipal.add(txtEndereco);
        
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(30, 260, 100, 25);
        painelPrincipal.add(lblCidade);
        
        txtCidade = new JTextField();
        txtCidade.setBounds(150, 260, 300, 25);
        painelPrincipal.add(txtCidade);
        
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 300, 100, 25);
        painelPrincipal.add(lblEstado);
        
        txtEstado = new JTextField();
        txtEstado.setBounds(150, 300, 300, 25);
        painelPrincipal.add(txtEstado);
        
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(30, 340, 100, 25);
        painelPrincipal.add(lblSenha);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(150, 340, 300, 25);
        painelPrincipal.add(txtSenha);
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(150, 390, 120, 30);
        btnCadastrar.setBackground(new Color(0, 150, 0));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        painelPrincipal.add(btnCadastrar);
        
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(280, 390, 120, 30);
        btnLimpar.setBackground(new Color(200, 200, 200));
        btnLimpar.setFocusPainted(false);
        painelPrincipal.add(btnLimpar);
        
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFornecedor();
            }
        });
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        
        this.setContentPane(painelPrincipal);
    }
    
    private void cadastrarFornecedor() {
        try {
            if (validarCampos()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(txtNome.getText());
                fornecedor.setCnpj(txtCnpj.getText());
                fornecedor.setTelefone(txtTelefone.getText());
                fornecedor.setEmail(txtEmail.getText());
                fornecedor.setEndereco(txtEndereco.getText());
                fornecedor.setCidade(txtCidade.getText());
                fornecedor.setEstado(txtEstado.getText());
                fornecedor.setSenha(new String(txtSenha.getPassword()));
                
                JOptionPane.showMessageDialog(this, 
                    "Fornecedor cadastrado com sucesso!", 
                    "Sucesso", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                limparCampos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao cadastrar fornecedor: " + ex.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validarCampos() {
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Nome é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocus();
            return false;
        }
        if (txtCnpj.getText().trim().isEmpty() || txtCnpj.getText().contains("_")) {
            JOptionPane.showMessageDialog(this, "O campo CNPJ é obrigatório e deve estar completo!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtCnpj.requestFocus();
            return false;
        }
        if (txtTelefone.getText().trim().isEmpty() || txtTelefone.getText().contains("_")) {
            JOptionPane.showMessageDialog(this, "O campo Telefone é obrigatório e deve estar completo!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtTelefone.requestFocus();
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Email é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }
        if (txtSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "O campo Senha é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtSenha.requestFocus();
            return false;
        }
        if (txtSenha.getPassword().length < 6) {
            JOptionPane.showMessageDialog(this, "A senha deve ter no mínimo 6 caracteres!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtSenha.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limparCampos() {
        txtNome.setText("");
        txtCnpj.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtSenha.setText("");
        txtNome.requestFocus();
    }
}