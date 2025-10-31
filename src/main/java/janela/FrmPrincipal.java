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
    private JMenu menuUsuario;

    private FrmLogin janelaLoginCliente;
    private FrmLoginForne janelaLoginFornecedor;


    private JMenuItem menuCadastroCliente;
    private JMenuItem menuCadastroFornecedor;
    private JMenuItem menuCadastroProduto;
    private JMenuItem menuPesquisarProduto;
    private JMenuItem itemLogout;

    private JDesktopPane desktop;

    private FrmLojaPrincipal janelaLoja;
    private FrmLogin janelaLogin;
    private FrmCadastro janelaCadastro;
    private FrmCadastroFornecedor janelaCadastroFornecedor;
    private FrmCadastroProduto janelaCadastroProduto;
    private FrmPesquisaProduto janelaPesquisaProduto;


    public void mostrarMenuProdutoFornecedor(boolean mostrar) {
        menuCadastroProduto.setVisible(mostrar);
    }


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


        menuCadastro = new JMenu("Cadastro");
        menuPesquisa = new JMenu("Pesquisar");
        menuLogin = new JMenu("Login");
        menuUsuario = new JMenu("Usuário");

        menuBar.add(menuCadastro);
        menuBar.add(menuLogin);
        menuBar.add(menuPesquisa);
        menuBar.add(menuUsuario);

        menuCadastroCliente = new JMenuItem("Cadastro Cliente");
        menuCadastro.add(menuCadastroCliente);

        menuCadastroFornecedor = new JMenuItem("Cadastro Fornecedor");
        menuCadastro.add(menuCadastroFornecedor);

        menuCadastroProduto = new JMenuItem("Cadastro Produto");
        menuCadastro.add(menuCadastroProduto);

        menuCadastroProduto.setVisible(false);


        JMenuItem itemLogin = new JMenuItem("Login Cliente");
        menuLogin.add(itemLogin);

        JMenuItem itemLogin1 = new JMenuItem("Login Fornecedor");
        menuLogin.add(itemLogin1);

        menuPesquisarProduto = new JMenuItem("Pesquisar Produto");
        menuPesquisa.add(menuPesquisarProduto);

        itemLogout = new JMenuItem("Logout");
        menuUsuario.add(itemLogout);

        desktop = new JDesktopPane();
        this.add(desktop);


        desktop.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (janelaLoja != null) {
                    janelaLoja.setBounds(0, 0, desktop.getWidth(), desktop.getHeight());
                }
            }
        });


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
                if (janelaLoginCliente == null || janelaLoginCliente.isClosed()) {
                    janelaLoginCliente = new FrmLogin(FrmPrincipal.this);
                    desktop.add(janelaLoginCliente);
                }
                janelaLoginCliente.setVisible(true);
                try {
                    if (janelaLoginCliente.isIcon()) janelaLoginCliente.setIcon(false);
                    janelaLoginCliente.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemLogin1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (janelaLoginFornecedor == null || janelaLoginFornecedor.isClosed()) {
                    janelaLoginFornecedor = new FrmLoginForne(FrmPrincipal.this);
                    desktop.add(janelaLoginFornecedor);
                }
                janelaLoginFornecedor.setVisible(true);
                try {
                    if (janelaLoginFornecedor.isIcon()) janelaLoginFornecedor.setIcon(false);
                    janelaLoginFornecedor.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });


        menuCadastroFornecedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (janelaCadastroFornecedor == null || janelaCadastroFornecedor.isClosed()) {
                    janelaCadastroFornecedor = new FrmCadastroFornecedor();
                    desktop.add(janelaCadastroFornecedor);
                }
                janelaCadastroFornecedor.setVisible(true);
                try {
                    if (janelaCadastroFornecedor.isIcon()) janelaCadastroFornecedor.setIcon(false);
                    janelaCadastroFornecedor.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });

        menuCadastroProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (janelaCadastroProduto == null || janelaCadastroProduto.isClosed()) {
                    janelaCadastroProduto = new FrmCadastroProduto();
                    desktop.add(janelaCadastroProduto);
                }
                janelaCadastroProduto.setVisible(true);
                try {
                    if (janelaCadastroProduto.isIcon()) janelaCadastroProduto.setIcon(false);
                    janelaCadastroProduto.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }

            }
        });

        menuPesquisarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (janelaPesquisaProduto == null || janelaPesquisaProduto.isClosed()) {
                    janelaPesquisaProduto = new FrmPesquisaProduto();
                    desktop.add(janelaPesquisaProduto);
                }
                janelaPesquisaProduto.setVisible(true);
                try {
                    if (janelaPesquisaProduto.isIcon()) janelaPesquisaProduto.setIcon(false);
                    janelaPesquisaProduto.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerenciarVisibilidadeMenus(false);
                menuCadastroProduto.setVisible(false);

            }
        });


        this.setVisible(true);
        abrirJanelaLoja();
        gerenciarVisibilidadeMenus(false);

    }

    public void gerenciarVisibilidadeMenus(boolean logado) {
        menuCadastro.setVisible(!logado);
        menuLogin.setVisible(!logado);


        menuUsuario.setVisible(logado);

        if (!logado) {
            for (JInternalFrame frame : desktop.getAllFrames()) {
                if (!(frame instanceof FrmLojaPrincipal)) {
                    frame.dispose();
                }
            }
            janelaCadastro = null;
            janelaLogin = null;
            janelaCadastroFornecedor = null;
            janelaCadastroProduto = null;
            janelaPesquisaProduto = null;
        }
    }
    public void loginFornecedor() {

        menuLogin.setVisible(false);
        menuUsuario.setVisible(true);
        itemLogout.setVisible(true);


        menuCadastro.setVisible(true);
        menuCadastroProduto.setVisible(true);
        menuCadastroCliente.setVisible(false);
        menuCadastroFornecedor.setVisible(false);


        menuPesquisa.setVisible(true);
    }


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
