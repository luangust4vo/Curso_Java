package Screens;


import Armazenamento.Persistencia;
import Modelos.Pessoa;
import Telas.TelaPrincipal;

import javax.swing.*;
import java.awt.*;

public class TelaAdmin {

    JPanel painel;
    JFrame tela;

    public TelaAdmin(TelaPrincipal telaPrincipal) {
        painel = new JPanel(null);
        tela = new JFrame("Tela - Admin");

        tela.setSize(400, 185);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.add(painel);

        painel.setLayout(null);


        JLabel labelUsuario = new JLabel("Usuário");
        labelUsuario.setBounds(50, 35, 80, 25);
        painel.add(labelUsuario);

        JTextField textoUsuario = new JTextField();
        textoUsuario.setBounds(140, 35, 165, 25);
        painel.add(textoUsuario);

        JLabel label = new JLabel("Não há uma conta com esté usuário.");
        label.setForeground(Color.red);
        label.setBounds(95, 120, 250, 30);
        label.setVisible(false);
        painel.add(label);

        JButton botaoMudarSenha = new JButton("Mudar Senha");
        botaoMudarSenha.setBounds(15, 90, 125, 30);
        botaoMudarSenha.addActionListener((a) -> {
            String usuario = textoUsuario.getText().toLowerCase();
            if(usuario.replace(" ", "").isEmpty()) {
                label.setVisible(true);
                label.setText("O usuário precisa estar preenchido.");
                return;
            }
            if(!Persistencia.temCadastro(usuario)) {
                label.setVisible(true);
                return;
            }

            TelaMudarSenha telaMudarSenha = new TelaMudarSenha(textoUsuario.getText().toLowerCase());
            telaMudarSenha.abrirTela();

            textoUsuario.setText("");
        });
        painel.add(botaoMudarSenha);

        JButton botaoDeletar = new JButton("Deletar");
        botaoDeletar.setBounds(155, 90, 100, 30);
        botaoDeletar.addActionListener((a) -> {
            String usuario = textoUsuario.getText().toLowerCase();
            if(usuario.replace(" ", "").isEmpty()) {
                label.setVisible(true);
                label.setText("O usuário precisa estar preenchido.");
                return;
            }
            if(!Persistencia.temCadastro(usuario)) {
                label.setVisible(true);
                return;
            }

            //showconfirmdialog = tela de confirmacao
            //Mensagem, titulo
            //yes_no_option = Opções Sim ou Não.
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja confimar?", "Deletar conta", JOptionPane.YES_NO_OPTION);

            //opcao 0 - primeira opção = sim
            //opcao 1 - segunda opção = nao
            if(opcao == 0) {
                Persistencia.deletar(usuario.toLowerCase());

                textoUsuario.setText("");
                label.setVisible(true);
                label.setText("Usuário deletado com êxito.");
            }else {
                textoUsuario.setText("");
            }
        });
        painel.add(botaoDeletar);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(270, 90, 100, 30);
        botaoVoltar.addActionListener((a) -> {
            telaPrincipal.abrirTela();
            fecharTela();
        });
        painel.add(botaoVoltar);


        tela.setVisible(false);
    }

    public void abrirTela() {
        tela.setVisible(true);
    }

    public void fecharTela() {
        tela.setVisible(false);
    }
}