package janela;

import Classes.Cadastro;

import Repository.CadastroRepository;
import util.FormUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
    private JButton Cancelar;

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

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Declara um vetor com os campos  do formulário
                JTextField[]  campos = {textfieldEmail, textfieldSenha,textfieldNome,textefiedCpf,textfiledIdade};

                if (FormUtil.hasEmpty(campos)) {
                    // Exibe mensagem de erro caso algum campo esteja vazio
                    JOptionPane.showMessageDialog(FrmCadastro.this,
                            "Preencher todos os campos obrigatórios",
                            "Erro ao salvar",
                            JOptionPane.ERROR_MESSAGE);

                } else {
                    // Cria um objeto Livro com os dados digitados no formulário e exibe no formato CSV
                    // O metodo getText() pega o texto digitado no campo de entrada
                    Cadastro pessoa = new Cadastro();
                    pessoa.setSenha(textfieldSenha.getText());
                    pessoa.setEmail(textfieldEmail.getText());
                    pessoa.setIdade(Integer.parseInt(textfiledIdade.getText()));
                    pessoa.setNome(textfieldNome.getText());
                    pessoa.setCpf(textefiedCpf.getText());

                    try {

                        CadastroRepository.inserir(pessoa);

                        FormUtil.cleanJTexts(campos);

                        JOptionPane.showMessageDialog(
                                FrmCadastro.this,
                                "Salvo com Sucesso!",
                                "Sucesso",
                                JOptionPane.INFORMATION_MESSAGE);

                    } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Erro ao inserir livro: " + ex.getMessage()
                        );
                    }
                }

            }
        });

        Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCadastro.this.dispose();
            }
        });
    }
}
