package Telas;


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TelaPrincipal {

        JPanel painel;
        JFrame tela;

        public TelaPrincipal() {
                painel = new JPanel(null);
                tela = new JFrame("Tela - Principal");

                int width = 600;
                int height = 400;

                tela.setSize(width, height);
                tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tela.setResizable(false);
                tela.add(painel);
                tela.setLocationRelativeTo(null);

                JLabel bemVindoLabel = new JLabel("Bem-vindo ao sistema de");
                bemVindoLabel.setFont(new Font("Arial", Font.BOLD, 24));
                bemVindoLabel.setBounds(150, 25, 400, bemVindoLabel.getFont().getSize());
                painel.add(bemVindoLabel);

                JLabel lcLabel = new JLabel("Login e Cadastro");
                lcLabel.setFont(new Font("Arial", Font.BOLD, 32));
                lcLabel.setBounds(165, 60, 400, lcLabel.getFont().getSize());
                painel.add(lcLabel);


                JButton botaoCadastro = new JButton("Cadastrar");
                botaoCadastro.setBounds(215, 125, 150, 50);
                botaoCadastro.setBackground(Color.black);
                botaoCadastro.setForeground(Color.white);

                botaoCadastro.addActionListener(e -> {
                        TelaCadastro telaCadastro = new TelaCadastro(this);
                        telaCadastro.abrirTela();
                        fecharTela();
                });
                painel.add(botaoCadastro);

                JButton botaoLogar = new JButton("Logar");
                botaoLogar.setBounds(215, 185, 150, 50);
                botaoLogar.setBackground(Color.black);
                botaoLogar.setForeground(Color.white);
                botaoLogar.addActionListener(e -> {
                        TelaLogin telaLogin = new TelaLogin(this);
                        telaLogin.abrirTela();
                        fecharTela();
                });
                painel.add(botaoLogar);

                JButton botaoAdmin = new JButton("Admin");
                botaoAdmin.setBounds(190, 270, 200, 70);
                botaoAdmin.setBackground(Color.orange);
                botaoAdmin.setForeground(Color.black);
                painel.add(botaoAdmin);

                tela.setVisible(false);
        }

        public void abrirTela() {
                tela.setVisible(true);
        }

        public void fecharTela() {
                tela.setVisible(false);
        }
}