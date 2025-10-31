package janela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPesquisaProduto extends JInternalFrame {
    private JPanel painelPrincipal;
    private JTextField txtPesquisa;
    private JButton btnPesquisar;
    private JButton btnLimpar;
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;

    public FrmPesquisaProduto() {
        this.setTitle("Pesquisar Produto");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700, 500);
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
        JLabel lblTitulo = new JLabel("Pesquisar Produto");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(250, 10, 250, 30);
        painelPrincipal.add(lblTitulo);
        
        // Campo de pesquisa
        JLabel lblPesquisa = new JLabel("Nome do Produto:");
        lblPesquisa.setBounds(30, 60, 120, 25);
        painelPrincipal.add(lblPesquisa);
        
        txtPesquisa = new JTextField();
        txtPesquisa.setBounds(160, 60, 350, 25);
        txtPesquisa.setToolTipText("Digite o nome do produto para pesquisar");
        painelPrincipal.add(txtPesquisa);
        
        // Botões
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(520, 60, 120, 25);
        btnPesquisar.setBackground(new Color(0, 120, 215));
        btnPesquisar.setForeground(Color.WHITE);
        btnPesquisar.setFocusPainted(false);
        painelPrincipal.add(btnPesquisar);
        
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(520, 95, 120, 25);
        btnLimpar.setBackground(new Color(200, 200, 200));
        btnLimpar.setFocusPainted(false);
        painelPrincipal.add(btnLimpar);
        
        // Tabela de resultados
        String[] colunas = {"ID", "Nome", "Tipo", "Preço", "Quantidade", "Marca"};
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabelaProdutos = new JTable(modeloTabela);
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaProdutos.getTableHeader().setReorderingAllowed(false);
        tabelaProdutos.setRowHeight(25);
        
        // Ajusta largura das colunas
        tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabelaProdutos.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabelaProdutos.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        scrollPane = new JScrollPane(tabelaProdutos);
        scrollPane.setBounds(30, 130, 640, 310);
        painelPrincipal.add(scrollPane);
        
        // Listeners
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarProduto();
            }
        });
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPesquisa();
            }
        });
        
        txtPesquisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarProduto();
            }
        });
        
        this.setContentPane(painelPrincipal);
    }
    
    private void pesquisarProduto() {
        String termoPesquisa = txtPesquisa.getText().trim();
        
        if (termoPesquisa.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Digite o nome do produto para pesquisar!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        modeloTabela.setRowCount(0);
        
        // TODO: Integrar com ProdutoRepository
        Object[][] dadosExemplo = {
            {1, "Bola Adidas UCL", "Bola", "R$ 1.666,66", 10, "Adidas"},
            {2, "Bola Futsal LNF", "Bola", "R$ 2.001,99", 5, "Penalty"},
            {3, "Camisa Flamengo", "Camisa", "R$ 0,00", 50, "Adidas"}
        };
        
        for (Object[] linha : dadosExemplo) {
            String nomeProduto = (String) linha[1];
            if (nomeProduto.toLowerCase().contains(termoPesquisa.toLowerCase())) {
                modeloTabela.addRow(linha);
            }
        }
        
        if (modeloTabela.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum produto encontrado com o nome \"" + termoPesquisa + "\"",
                    "Resultado da Pesquisa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void limparPesquisa() {
        txtPesquisa.setText("");
        modeloTabela.setRowCount(0);
        txtPesquisa.requestFocus();
    }
}
