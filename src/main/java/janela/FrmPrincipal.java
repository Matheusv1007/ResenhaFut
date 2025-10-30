package janela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

public class FrmPrincipal extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuCadastro;
    private JMenu menuPesquisa;
    private JMenu menuLogin;
    // private JMenu menuLoja; // --- REMOVIDO ---
    private JMenu menuUsuario;

    private JMenuItem menuCadastroCliente;
    private JMenuItem menuPesquisarProduto;
    // private JMenuItem itemAbrirLoja; // --- REMOVIDO ---
    private JMenuItem itemLogout;

    private JDesktopPane desktop;

    private FrmLojaPrincipal janelaLoja;
    private FrmLogin janelaLogin;
    private FrmCadastro janelaCadastro;

    public FrmPrincipal() {
        this.setTitle("Resenha Fut");
        this.setMinimumSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        URL logoUrl = getClass().getResource("/logo.jpg");
        if (logoUrl != null) {
            this.setIconImage(new ImageIcon(logoUrl).getImage());
        }

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        // --- MENUS ---
        // menuLoja = new JMenu("Loja"); // --- REMOVIDO ---
        menuCadastro = new JMenu("Cadastro");
        menuPesquisa = new JMenu("Pesquisar"); // <--- "Pesquisar" está aqui
        menuLogin = new JMenu("Login");
        menuUsuario = new JMenu("Usuário");

        // --- ORDEM DA BARRA ---
        // menuBar.add(menuLoja); // --- REMOVIDO ---
        menuBar.add(menuCadastro);
        menuBar.add(menuLogin);
        menuBar.add(menuPesquisa); // <--- "Pesquisar" está aqui
        menuBar.add(menuUsuario);

        // --- ITENS DE MENU ---
        menuCadastroCliente = new JMenuItem("Cadastro Cliente");
        menuCadastro.add(menuCadastroCliente);

        JMenuItem itemLogin = new JMenuItem("Realizar Login");
        menuLogin.add(itemLogin);

        menuPesquisarProduto = new JMenuItem("Pesquisar Produto");
        menuPesquisa.add(menuPesquisarProduto);

        // --- ITENS DO MENU LOJA REMOVIDOS ---
        // itemAbrirLoja = new JMenuItem("Ver Loja");
        // menuLoja.add(itemAbrirLoja);
        // itemAbrirLoja.setEnabled(false);

        itemLogout = new JMenuItem("Logout");
        menuUsuario.add(itemLogout);

        desktop = new JDesktopPane();
        this.add(desktop);

        // Listener de redimensionamento (continua igual)
        desktop.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (janelaLoja != null) {
                    janelaLoja.setBounds(0, 0, desktop.getWidth(), desktop.getHeight());
                }
            }
        });

        // Listeners de menu (Cadastro, Login, Logout) (continuam iguais)
        menuCadastroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (janelaCadastro == null || janelaCadastro.isClosed()) {
                    janelaCadastro = new FrmCadastro();
                    desktop.add(janelaCadastro);
                }
                janelaCadastro.setVisible(true);
                try {
                    if (janelaCadastro.isIcon()) janelaCadastro.setIcon(false);
                    janelaCadastro.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (janelaLogin == null || janelaLogin.isClosed()) {
                    janelaLogin = new FrmLogin(FrmPrincipal.this);
                    desktop.add(janelaLogin);
                }
                janelaLogin.setVisible(true);
                try {
                    if (janelaLogin.isIcon()) janelaLogin.setIcon(false);
                    janelaLogin.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerenciarVisibilidadeMenus(false);
            }
        });

        // --- Inicialização ---
        this.setVisible(true);
        abrirJanelaLoja(); // Abre a loja
        gerenciarVisibilidadeMenus(false);
    }


    public void gerenciarVisibilidadeMenus(boolean logado) {
        menuCadastro.setVisible(!logado);
        menuLogin.setVisible(!logado);

        // --- MUDANÇA AQUI ---
        // Removemos o menu "Pesquisar" desta lógica.
        // Agora ele ficará sempre visível.
        // menuPesquisa.setVisible(logado); // <--- LINHA REMOVIDA

        menuUsuario.setVisible(logado);

        if (!logado) {
            for (JInternalFrame frame : desktop.getAllFrames()) {
                if (!(frame instanceof FrmLojaPrincipal)) {
                    frame.dispose();
                }
            }
            janelaCadastro = null;
            janelaLogin = null;
        }
    }


    /**
     * Abre a janela da loja (agora fixa)
     * (Este método continua igual)
     */
    private void abrirJanelaLoja() {
        if (janelaLoja == null) {
            janelaLoja = new FrmLojaPrincipal();
            desktop.add(janelaLoja);
            janelaLoja.setVisible(true);

            try {
                janelaLoja.setBounds(0, 0, desktop.getWidth(), desktop.getHeight());
            } catch (Exception e) {
                e.printStackTrace();
            }

            desktop.moveToBack(janelaLoja);
        }
    }
}