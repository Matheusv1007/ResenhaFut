package janela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuCadastro;
    private  JMenu menuPesquisa;
    private JMenuItem menuCadastroCliente;
    private  JMenuItem menuPesquisarProduto;
    private JDesktopPane desktop;
    private JMenuItem menucadastroCliente;

    public FrmPrincipal(){
        this.setTitle("Resenha Fut");
        this.setMinimumSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        new ImageIcon("src\\logo.jpg");

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menuCadastro = new JMenu("Cadastro");
        menuPesquisa = new JMenu("Pesquisar");

        menuBar.add(menuCadastro);
        menuBar.add(menuPesquisa);

        menucadastroCliente = new JMenuItem();
        menucadastroCliente.setText("Cadastro Cliente");
        menuCadastro.add(menucadastroCliente);

        //para criar o listener q vai fzr com q possa clikar no botao

        menuCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCadastro cadastro = new FrmCadastro();
                desktop.add(cadastro);
            }
        });

        desktop = new JDesktopPane();
        this.add(desktop);

        this.setVisible(true);
    }

}
