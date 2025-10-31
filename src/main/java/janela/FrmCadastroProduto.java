package janela;

import Classes.Produto;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class FrmCadastroProduto extends JInternalFrame {
    private JPanel painelPrincipal;
    private JTextField txtNome;
    private JTextField txtTipoProduto;
    private JFormattedTextField txtPreco;
    private JFormattedTextField txtQuantidade;
    private JTextField txtMarca;
    private JButton btnCadastrar;
    private JButton btnLimpar;

    public FrmCadastroProduto() {
        this.setTitle("Cadastro de Produto");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
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
        
        // Labels e campos
        JLabel lblTitulo = new JLabel("Cadastro de Produto");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(150, 10, 250, 30);
        painelPrincipal.add(lblTitulo);
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 60, 100, 25);
        painelPrincipal.add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(150, 60, 300, 25);
        ((AbstractDocument) txtNome.getDocument()).setDocumentFilter(new LetrasEspacosFilter());
        painelPrincipal.add(txtNome);
        
        JLabel lblTipoProduto = new JLabel("Tipo Produto:");
        lblTipoProduto.setBounds(30, 100, 100, 25);
        painelPrincipal.add(lblTipoProduto);
        
        txtTipoProduto = new JTextField();
        txtTipoProduto.setBounds(150, 100, 300, 25);
        ((AbstractDocument) txtTipoProduto.getDocument()).setDocumentFilter(new LetrasEspacosFilter());
        painelPrincipal.add(txtTipoProduto);
        
        JLabel lblPreco = new JLabel("Preço (R$):");
        lblPreco.setBounds(30, 140, 100, 25);
        painelPrincipal.add(lblPreco);
        
        txtPreco = new JFormattedTextField();
        txtPreco.setBounds(150, 140, 300, 25);
        txtPreco.setToolTipText("Digite apenas números. Ex: 99.99");
        ((AbstractDocument) txtPreco.getDocument()).setDocumentFilter(new NumeroDecimalFilter());
        painelPrincipal.add(txtPreco);
        
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(30, 180, 100, 25);
        painelPrincipal.add(lblQuantidade);
        
        txtQuantidade = new JFormattedTextField();
        txtQuantidade.setBounds(150, 180, 300, 25);
        txtQuantidade.setToolTipText("Digite apenas números inteiros. Ex: 100");
        ((AbstractDocument) txtQuantidade.getDocument()).setDocumentFilter(new NumeroInteiroFilter());
        painelPrincipal.add(txtQuantidade);
        
        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(30, 220, 100, 25);
        painelPrincipal.add(lblMarca);
        
        txtMarca = new JTextField();
        txtMarca.setBounds(150, 220, 300, 25);
        ((AbstractDocument) txtMarca.getDocument()).setDocumentFilter(new LetrasEspacosFilter());
        painelPrincipal.add(txtMarca);
        
        // Botões
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(150, 280, 120, 30);
        btnCadastrar.setBackground(new Color(0, 150, 0));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        painelPrincipal.add(btnCadastrar);
        
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(280, 280, 120, 30);
        btnLimpar.setBackground(new Color(200, 200, 200));
        btnLimpar.setFocusPainted(false);
        painelPrincipal.add(btnLimpar);
        
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
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
    
    private void cadastrarProduto() {
        try {
            if (validarCampos()) {
                Produto produto = new Produto();
                produto.setNome(txtNome.getText());
                produto.setTipoProduto(txtTipoProduto.getText());
                produto.setPreco(Double.parseDouble(txtPreco.getText()));
                produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
                produto.setMarca(txtMarca.getText());
                
                JOptionPane.showMessageDialog(this, 
                    "Produto cadastrado com sucesso!", 
                    "Sucesso", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                limparCampos();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Erro: Preço e Quantidade devem ser números válidos!", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao cadastrar produto: " + ex.getMessage(), 
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
        if (txtTipoProduto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Tipo Produto é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtTipoProduto.requestFocus();
            return false;
        }
        if (txtPreco.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Preço é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtPreco.requestFocus();
            return false;
        }
        if (txtQuantidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Quantidade é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtQuantidade.requestFocus();
            return false;
        }
        if (txtMarca.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Marca é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtMarca.requestFocus();
            return false;
        }
        
        try {
            Double.parseDouble(txtPreco.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O campo Preço deve ser um número válido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtPreco.requestFocus();
            return false;
        }
        
        try {
            Integer.parseInt(txtQuantidade.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O campo Quantidade deve ser um número inteiro válido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtQuantidade.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private void limparCampos() {
        txtNome.setText("");
        txtTipoProduto.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
        txtMarca.setText("");
        txtNome.requestFocus();
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
    
    // Filtro para permitir apenas números decimais
    private class NumeroDecimalFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[0-9.]*")) {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
                // Permite apenas um ponto decimal
                if (newText.chars().filter(ch -> ch == '.').count() <= 1) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        }
        
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[0-9.]*")) {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                // Permite apenas um ponto decimal
                if (newText.chars().filter(ch -> ch == '.').count() <= 1) {
                    super.replace(fb, offset, length, text, attrs);
                }
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
}