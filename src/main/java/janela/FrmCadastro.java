package janela;

import Classes.Cadastro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCadastro extends JInternalFrame{
    private JPanel jpanel;
    private JFormattedTextField textfieldNome;
    private JFormattedTextField textfiledIdade;
    private JFormattedTextField textefiedCpf;
    private JFormattedTextField textfieldEmail;
    private JFormattedTextField textfieldSenha;
    private JButton cadastrar;
    private JLabel confirmarSenha;
    private JLabel senha;
    private JLabel cpf;
    private JLabel idade;
    private JLabel nome;

    public FrmCadastro() {

        this.setTitle("Cadastro");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(480,400);
        this.setResizable(false);
        this.setClosable(true);
        this.setResizable(true);
        this.setResizable(false);
        this.setIconifiable(true);
        this.setContentPane(jpanel);
        this.setVisible(true);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Cadastro pessoa =  new Cadastro();
               pessoa.setSenha(textfieldSenha.getText());
               pessoa.setCpf(textefiedCpf.getText());
               pessoa.setEmail(textfieldEmail.getText());
               pessoa.setNome(textfieldNome.getText());
               pessoa.setIdade(Integer.parseInt(textfiledIdade.getText()));

            }
        });
    }
}
