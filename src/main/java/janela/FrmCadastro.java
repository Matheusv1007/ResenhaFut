package janela;

import Classes.Cadastro;
import Repository.CadastroRepository;
import util.FormUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrmCadastro extends JInternalFrame {
    private JPanel jpanel;
    private JFormattedTextField textfieldNome;
    private JFormattedTextField textfiledIdade;
    private JFormattedTextField textefiedCpf;
    private JFormattedTextField textfieldEmail;
    // Remova o textfieldSenha se você estiver usando o JPasswordField
    // private JFormattedTextField textfieldSenha;
    private JButton cadastrar;
    private JLabel confirmarSenha;
    private JLabel senha;
    private JLabel cpf;
    private JLabel idade;
    private JLabel nome;
    private JButton Cancelar;
    private JPasswordField textpassword; // Este é o campo de senha correto

    public FrmCadastro() {

        this.setTitle("Cadastro");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha só esta janela
        this.setSize(480, 400);
        this.setResizable(false);
        this.setClosable(true);
        this.setIconifiable(true); // Permite minimizar
        this.setContentPane(jpanel);
        this.setVisible(true);

        // Apenas UM ActionListener para o botão cadastrar
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Declara um vetor com os campos de texto do formulário
                JTextField[] campos = {textfieldEmail, textfieldNome, textefiedCpf, textfiledIdade};

                // Pega a senha da forma correta
                String senha = new String(textpassword.getPassword());

                // Verifica se campos de texto OU a senha estão vazios
                if (FormUtil.hasEmpty(campos) || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(FrmCadastro.this,
                            "Preencher todos os campos obrigatórios",
                            "Erro ao salvar",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Cadastro pessoa = new Cadastro();
                    pessoa.setSenha(senha); // Usa a senha do JPasswordField
                    pessoa.setEmail(textfieldEmail.getText());
                    pessoa.setIdade(Integer.parseInt(textfiledIdade.getText()));
                    pessoa.setNome(textfieldNome.getText());
                    pessoa.setCpf(textefiedCpf.getText());

                    try {
                        CadastroRepository.inserir(pessoa);

                        // Limpa os campos
                        FormUtil.cleanJTexts(campos);
                        textpassword.setText(""); // Limpa a senha manualmente

                        JOptionPane.showMessageDialog(
                                FrmCadastro.this,
                                "Salvo com Sucesso!",
                                "Sucesso",
                                JOptionPane.INFORMATION_MESSAGE);

                        dispose(); // Fecha a janela de cadastro após sucesso

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erro ao inserir no banco: " + ex.getMessage()
                        );
                        ex.printStackTrace();
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erro: A idade deve ser um número válido."
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
