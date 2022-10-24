package Models;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

    Player player;

    public Keyboard(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        player.keyPressed(event);
    }


    @Override
    public void keyReleased(KeyEvent event) {
        player.keyReleased(event);
    }
}
