package janela;

import javax.swing.*;

public class Janela extends JInternalFrame{

    public Janela(){
        this.setTitle("Resenha Fut");
        this.setSize(800,900);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
