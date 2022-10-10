package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {
        public TelaPrincipal(){
                JPanel painel = new JPanel();
                painel.setLayout(null);

                JFrame tela = new JFrame("Tela - Inicial");
                tela.setSize(600, 400);
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
                tela.add(painel);

                JLabel texto = new JLabel("Bem-vindo(a) ao");
                texto.setFont(new Font("Arial",Font.BOLD, 24));
                texto.setBounds(200, 25, 600, 48);
                painel.add(texto);

                JLabel titulo = new JLabel("Login e Cadastro");
                titulo.setFont(new Font("Arial", Font.BOLD, 36));
                titulo.setBounds(165, 60, 600, 48);
                painel.add(titulo);

                JButton botaoCadastro = new JButton("Cadastro");
                botaoCadastro.setBounds(215, 125, 150, 50);
                botaoCadastro.setBackground(Color.BLACK);
                botaoCadastro.setForeground(Color.WHITE);
                botaoCadastro.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                TelaCadastro telaCadastro = new TelaCadastro(TelaPrincipal.this);
                                telaCadastro.mostrarTela();
                        }
                });
                painel.add(botaoCadastro);

                JButton botaoLogin = new JButton("Login");
                botaoLogin.setBounds(215, 185, 150, 50);
                botaoLogin.setBackground(Color.BLACK);
                botaoLogin.setForeground(Color.WHITE);
                painel.add(botaoLogin);

                JButton botaoAdmin = new JButton("Admin");
                botaoAdmin.setBounds(190, 270, 200, 70);
                botaoAdmin.setBackground(Color.ORANGE);
                botaoAdmin.setForeground(Color.BLACK);
                painel.add(botaoAdmin);
        }
}
