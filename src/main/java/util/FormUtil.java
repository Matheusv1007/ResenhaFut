package util;

import javax.swing.text.JTextComponent;

/*
 * Classe utilitária para manipulação de componentes de texto (JTextComponent)
 * em formulários Swing.
 *
 * Oferece métodos estáticos para:
 *  - limpar campos de texto;
 *  - verificar se há campos vazios.
 */
public class FormUtil {

    /*
     * Limpa o conteúdo de todos os campos de texto informados.
     * Recebe um vetor contendo os componentes de texto (ex: JTextField, JTextArea, etc.)
     */
    public static void cleanJTexts(JTextComponent[] campos) {
        for (JTextComponent campo : campos) {
            // Evita NullPointerException caso algum elemento do array seja nulo
            if (campo != null) {
                campo.setText(""); // Define o texto como vazio
            }
        }
    }

    /*
     * Verifica se existe algum campo de texto vazio entre os informados.
     * Caso encontre, retorna true e posiciona o foco no primeiro campo vazio.
     *
     * Recebe um vetor contendo os componentes de texto (ex: JTextField, JTextArea, etc.)
     * Retorna true se houver algum campo vazio, false caso contrário
     */
    public static boolean hasEmpty(JTextComponent[] campos) {
        for (JTextComponent campo : campos) {
            // Evita NullPointerException caso algum elemento do array seja nulo
            //Verifica se o campo está vazio
            if (campo != null && campo.getText().trim().isEmpty()) {
                // Solicita o foco para o primeiro campo vazio encontrado
                campo.requestFocus();
                return true; // Retorna imediatamente após encontrar o campo vazio
            }
        }
        return false; // Nenhum campo vazio encontrado
    }
}