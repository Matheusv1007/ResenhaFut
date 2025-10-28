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
    private JMenuItem menuLogin;

    public FrmPrincipal() {
        this.setTitle("Resenha Fut");
        this.setMinimumSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon logo = new ImageIcon("src\\logo.jpg");
        this.setIconImage(logo.getImage());

        // Barra de menus
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        // Menus
        menuCadastro = new JMenu("Cadastro");
        menuPesquisa = new JMenu("Pesquisar");
        menuLogin = new JMenu("Login");
        menuBar.add(menuCadastro);
        menuBar.add(menuPesquisa);
        menuBar.add(menuLogin);

        // Itens de menu
        menuCadastroCliente = new JMenuItem("Cadastro Cliente");
        menuCadastro.add(menuCadastroCliente);

        JMenuItem itemLogin = new JMenuItem("Realizar Login");
        menuLogin.add(itemLogin);

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

        itemLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmLogin Login = new FrmLogin(FrmPrincipal.this);
                desktop.add(Login);
                Login.setVisible(true);
            }
        });

        this.setVisible(true);
    }

    public void esconder() {
        menuCadastro.setVisible(false);
        menuLogin.setVisible(false);
    }
}