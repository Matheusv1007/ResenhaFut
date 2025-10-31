package janela;

import javax.swing.*;
// IMPORTANTE: Adicione este import
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.net.URL;

public class FrmLojaPrincipal extends JInternalFrame {

    public FrmLojaPrincipal() {

        super(null,
                false,
                false,
                false,
                false);

        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        this.setBorder(null);

        setSize(800, 600);

        configurarPainelLoja();
    }
    private void configurarPainelLoja() {
        JPanel painelProdutos = new JPanel();
        painelProdutos.setLayout(new GridLayout(0, 3, 20, 20));
        painelProdutos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painelProdutos.add(criarCartaoProduto("Imagem/Bola de Futebol de Campo adidas UCL Club.jpg", "Bola de Futebol Adidas", "R$ 1.666,66"));
        painelProdutos.add(criarCartaoProduto("Imagem/bola futsal sala cup lnf.jpg", "Bola Oficial da Liga lnf", "R$ 2.001,99"));
        painelProdutos.add(criarCartaoProduto("Imagem/Camisa1Flamengo.jpg", "R$ 0 investimento pos 28/10 - time merda", "R$ 0,00"));
        painelProdutos.add(criarCartaoProduto("Imagem/Camisa1Internacional.jpg", "Melhor Time", "R$ 999..."));

        JScrollPane scrollPane = new JScrollPane(painelProdutos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel criarCartaoProduto(String imagemPath, String descricao, String preco) {

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