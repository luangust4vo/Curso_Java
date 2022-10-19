package Models;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter {

    Player player;

    public KeyBoard(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyDown(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyUp(e);
    }
}
