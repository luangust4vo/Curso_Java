package Telas;


import Armazenamento.Persistencia;
import Modelos.Pessoa;

import javax.swing.*;
import java.awt.*;

public class TelaMudarSenha {

    JPanel painel;
    JFrame tela;

    public TelaMudarSenha(TelaPrincipal telaPrincipal) {
        painel = new JPanel(null);
        tela = new JFrame("Tela - Mudar senha");

        tela.setSize(400, 200);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.add(painel);

        painel.setLayout(null);

        JLabel labelUsuario = new JLabel("Usuário");
        labelUsuario.setBounds(50, 35, 100, 25);
        painel.add(labelUsuario);

        JTextField textoUsuario = new JTextField();
        textoUsuario.setBounds(155, 35, 165, 25);
        painel.add(textoUsuario);

        JLabel labelSenha = new JLabel("Senha");
        labelSenha.setBounds(50, 35, 100, 25);
        painel.add(labelSenha);

        JTextField textoSenha = new JTextField();
        textoSenha.setBounds(155, 35, 165, 25);
        painel.add(textoSenha);

        JLabel label = new JLabel("");
        label.setForeground(Color.red);
        label.setBounds(95, 120, 250, 50);
        label.setVisible(false);
        painel.add(label);

        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setBounds(50, 90, 125, 30);
        botaoConfirmar.addActionListener(e -> {
            String usuario = textoUsuario.getText().toLowerCase();
            if(usuario.replace(" ", "").isEmpty()){
                label.setVisible(true);
                label.setText("O usuário precisa estar preenchido com algo.");
                return;
            }
            if(!Persistencia.temCadastro(usuario)) {
                label.setVisible(true);
                return;
            } else {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja confirmar?", "Mudar senha", JOptionPane.YES_NO_OPTION);
            }
        });
        painel.add(botaoConfirmar);
    }

    public void abrirTela() {
        tela.setVisible(true);
    }

    public void fecharTela() {
        tela.setVisible(false);
    }
}