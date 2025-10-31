package janela;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FrmDetalheProduto extends JInternalFrame {

    public FrmDetalheProduto(Object[] dadosProduto) {
        this.setTitle("Detalhes do Produto");
        this.setSize(500, 350);
        this.setClosable(true);
        this.setIconifiable(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());


        JPanel painelInfo = new JPanel();
        painelInfo.setLayout(new GridLayout(0, 2, 10, 10));
        painelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] labels = {"ID", "Nome", "Tipo", "Preço", "Quantidade", "Marca"};
        for (int i = 0; i < labels.length; i++) {
            painelInfo.add(new JLabel(labels[i] + ":"));
            painelInfo.add(new JLabel(dadosProduto[i].toString()));
        }

        this.add(painelInfo, BorderLayout.CENTER);


        JPanel painelImagem = new JPanel();
        painelImagem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String nomeProduto = dadosProduto[1].toString();


        String nomeArquivo = nomeProduto.toLowerCase()
                .replace(" ", "_")
                .replaceAll("[^a-z0-9_]", "") + ".jpg";


        URL caminhoImagem = getClass().getClassLoader().getResource("Produtos_Resenha/" + nomeArquivo);

        JLabel lblImagem;
        if (caminhoImagem != null) {
            ImageIcon icone = new ImageIcon(caminhoImagem);
            Image img = icone.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            lblImagem = new JLabel(new ImageIcon(img));
        } else {

            System.out.println("Imagem não encontrada: " + nomeArquivo);

            lblImagem = new JLabel("Imagem não disponível");
            lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
            lblImagem.setPreferredSize(new Dimension(200, 200));
        }

        painelImagem.add(lblImagem);
        this.add(painelImagem, BorderLayout.EAST);

        this.setVisible(true);
    }
}
