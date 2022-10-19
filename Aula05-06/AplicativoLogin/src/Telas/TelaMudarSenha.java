package Screens;


import Armazenamento.Persistencia;

import javax.swing.*;
import java.awt.*;

public class TelaMudarSenha {

    JPanel painel;
    JFrame tela;

    public TelaMudarSenha(String usuario) {
        painel = new JPanel(null);
        tela = new JFrame("Tela - Mudar Senha");

        tela.setSize(400, 200);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.add(painel);

        painel.setLayout(null);




        JLabel labelNovaSenha = new JLabel("Nova Senha");
        labelNovaSenha.setBounds(50, 35, 100, 25);
        painel.add(labelNovaSenha);

        JTextField textoNovaSenha = new JTextField();
        textoNovaSenha.setBounds(155, 35, 165, 25);
        painel.add(textoNovaSenha);

        JLabel label = new JLabel("A senha não pode ser igual à atual.");
        label.setForeground(Color.red);
        label.setBounds(95, 120, 250, 30);
        label.setVisible(false);
        painel.add(label);

        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setBounds(50, 90, 125, 30);
        botaoConfirmar.addActionListener((a) -> {
            if(textoNovaSenha.getText().equals(Persistencia.pessoas.get(usuario.toLowerCase()).senha)) {
                label.setVisible(true);
                return;
            }
            //showconfirmdialog = tela de confirmacao
            //Mensagem, titulo
            //yes_no_option = Opções Sim ou Não.

            int opcao = JOptionPane.showConfirmDialog(null, "Deseja confirmar?", "Mudar Senha", JOptionPane.YES_NO_OPTION);
            //opcao 0 - primeira opção = sim
            //opcao 1 - segunda opção = nao
            if(opcao == 0) {
                Persistencia.mudarSenha(Persistencia.pessoas.get(usuario.toLowerCase()), textoNovaSenha.getText());
                fecharTela();
            }else {
                textoNovaSenha.setText("");
            }
        });
        painel.add(botaoConfirmar);

        JButton botaoFechar = new JButton("Fechar");
        botaoFechar.setBounds(200, 90, 125, 30);
        botaoFechar.addActionListener((a) -> {
            fecharTela();
        });
        painel.add(botaoFechar);

        tela.setVisible(false);
    }

    public void abrirTela() {
        tela.setVisible(true);
    }

    public void fecharTela() {
        tela.setVisible(false);
    }
}