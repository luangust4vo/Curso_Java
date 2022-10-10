package Telas;

import javax.swing.*;

public class TelaCadastro {
    JFrame tela;

    public TelaCadastro(TelaPrincipal telaPrincipal){
        JPanel painel = new JPanel();
        painel.setLayout(null);

        tela = new JFrame("Tela - Cadastro");
        tela.setSize(400, 200);
        tela.setLocationRelativeTo(null);
        tela.setVisible(false);
        tela.add(painel);
    }

    public void mostrarTela(){
        tela.setVisible(true);
    }
    public void fecharTela(){
        tela.setVisible(false);
    }
}
