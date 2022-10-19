package Main;

import Models.Stage;

import javax.swing.*;

public class Game extends JFrame {

    public Game(){
        //Adicionando a classe 'Fase' ao projeto
        add(new Stage());

        //Especificações da janela do jogo criada
        setTitle("Spaceship Game");
        setSize(1824, 728);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        //Instanciação da classe 'Jogo'
        new Game();
    }
}
