package janela;

import javax.swing.*;
// IMPORTANTE: Adicione este import
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.net.URL;

public class FrmLojaPrincipal extends JInternalFrame {

    public FrmLojaPrincipal() {
        // --- MUDANÇA AQUI ---
        // Trocamos o construtor 'super()' para remover todos os controles
        // super("Loja - Resenha Fut", true, true, true, true); // <--- LINHA ANTIGA
        super(null,   // Título (null)
                false,  // Redimensionável (false)
                false,  // Fechável (false)
                false,  // Maximizável (false)
                false); // Minimizável (false)

        // Esta é a parte que remove a barra de título superior
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        // Remove qualquer borda que tenha sobrado
        this.setBorder(null);
        // --- FIM DA MUDANÇA ---

        // O tamanho será controlado pela FrmPrincipal, mas podemos definir um inicial
        setSize(800, 600);

        // O resto do seu código continua igual
        configurarPainelLoja();
    }

    /**
     * Configura o painel principal da loja com os produtos.
     * (Este método continua exatamente o mesmo, não precisa copiar de novo)
     */
    private void configurarPainelLoja() {
        JPanel painelProdutos = new JPanel();
        painelProdutos.setLayout(new GridLayout(0, 3, 20, 20));
        painelProdutos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painelProdutos.add(criarCartaoProduto("Imagem/Bola de Futebol de Campo adidas UCL Club.jpg", "Camisa do Time X - Edição Especial", "R$ 99,90"));
        painelProdutos.add(criarCartaoProduto("Imagem/bola futsal sala cup lnf.jpg", "Bola Oficial da Liga Y", "R$ 149,90"));
        painelProdutos.add(criarCartaoProduto("Imagem/Camisa1Flamengo.jpg", "Chuteira Z - Conforto e Agilidade", "R$ 299,90"));
        painelProdutos.add(criarCartaoProduto("Imagem/Camisa1Internacional.jpg", "Luva de Goleiro Profissional", "R$ 180,00"));

        JScrollPane scrollPane = new JScrollPane(painelProdutos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Scroll mais rápido

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Cria um JPanel que representa um cartão de produto.
     * (Este método continua exatamente o mesmo, não precisa copiar de novo)
     */
    private JPanel criarCartaoProduto(String imagemPath, String descricao, String preco) {
        // ... (código idêntico ao anterior) ...
        JPanel cartao = new JPanel();
        cartao.setLayout(new BoxLayout(cartao, BoxLayout.Y_AXIS));
        cartao.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        cartao.setPreferredSize(new Dimension(200, 300));
        cartao.setMaximumSize(new Dimension(200, 300));

        JLabel labelFoto = new JLabel();
        try {
            URL imageUrl = getClass().getResource("/" + imagemPath);
            if (imageUrl != null) {
                ImageIcon originalIcon = new ImageIcon(imageUrl);
                Image image = originalIcon.getImage();
                Image resizedImage = image.getScaledInstance(180, 120, Image.SCALE_SMOOTH);
                labelFoto.setIcon(new ImageIcon(resizedImage));
            } else {
                labelFoto.setText("Sem Imagem");
                System.err.println("Imagem não encontrada: /" + imagemPath);
            }
        } catch (Exception e) {
            labelFoto.setText("Erro Imagem");
            e.printStackTrace();
        }
        labelFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartao.add(labelFoto);
        cartao.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextArea areaDescricao = new JTextArea(descricao);
        areaDescricao.setWrapStyleWord(true);
        areaDescricao.setLineWrap(true);
        areaDescricao.setEditable(false);
        areaDescricao.setFocusable(false);
        areaDescricao.setBackground(getBackground());
        areaDescricao.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        areaDescricao.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartao.add(areaDescricao);

        JLabel labelPreco = new JLabel(preco);
        labelPreco.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelPreco.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartao.add(labelPreco);
        cartao.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton botao = new JButton("Ver Detalhes");
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Detalhes para: " + descricao);
        });
        cartao.add(botao);
        cartao.add(Box.createVerticalGlue());

        return cartao;
    }
}