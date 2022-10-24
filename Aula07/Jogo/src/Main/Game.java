package Main;


import Models.Stage;
import javax.swing.*;

public class Game extends JFrame {

    public Game() {
        add(new Stage());
        setTitle("Spaceship Game");
        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
