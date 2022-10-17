package Telas;

import Modelos.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;

public class TelaUsuario {
     private JPanel painel;
     private JFrame tela;

     public TelaUsuario(Pessoa pessoa, TelaPrincipal telaPrincipal){
         painel = new JPanel(null);
         tela = new JFrame("Tela - Usuário");

         tela.setSize(600, 240);
         tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         tela.setResizable(false);
         tela.setLocationRelativeTo(null);
         tela.add(painel);

         painel.setLayout(null);

         JLabel bemVindoTexto = new JLabel("Bem-vindo, ");
         bemVindoTexto.setFont(new Font("Arial", Font.ITALIC, 24));
         bemVindoTexto.setBounds(240, 25, 600, 25);
         painel.add(bemVindoTexto);

         JLabel usuarioTexto = new JLabel(pessoa.usuario);
         usuarioTexto.setFont(new Font("Arial", Font.BOLD, 48));
         usuarioTexto.setBounds(250, 60, 400, 50);
         painel.add(usuarioTexto);

         JButton botaoSair = new JButton("Sair");
         botaoSair.setForeground(Color.BLACK);
         botaoSair.setBackground(Color.RED);
         botaoSair.setBounds(230, 120,150, 40);
         botaoSair.addActionListener(e -> {
             telaPrincipal.abrirTela();
             fecharTela();
         });
         painel.add(botaoSair);
     }

     public void abrirTela(){
         tela.setVisible(true);
     }
    public void fecharTela(){
        tela.setVisible(false);
    }
}
