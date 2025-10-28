package janela;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuCadastro;
    private JMenu menuPesquisa;
    private JMenuItem menuCadastroCliente;
    private JMenuItem menuPesquisarProduto;
    private JDesktopPane desktop;

    public FrmPrincipal() {
        this.setTitle("Resenha Fut");
        this.setMinimumSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        new ImageIcon("src\\logo.jpg");

        // Barra de menus
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        // Menus
        menuCadastro = new JMenu("Cadastro");
        menuPesquisa = new JMenu("Pesquisar");
        menuBar.add(menuCadastro);
        menuBar.add(menuPesquisa);

        // Itens de menu
        menuCadastroCliente = new JMenuItem("Cadastro Cliente");
        menuCadastro.add(menuCadastroCliente);

        // DesktopPane (onde aparecem as janelas internas)
        desktop = new JDesktopPane();
        this.add(desktop);

        // Listener do item de menu
        menuCadastroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmCadastro cadastro = new FrmCadastro();
                desktop.add(cadastro);
                cadastro.setVisible(true);
            }
        });

        this.setVisible(true);
    }
}