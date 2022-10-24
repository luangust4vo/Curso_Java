package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Player {

    Image image;

    int x;
    int y;

    int velocityY;

    int width;
    int height;

    ArrayList<Shot> shots;

    public Player() {
        x = 100;
        y = 100;

        shots = new ArrayList<>();
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public void shoot() {
        shots.add(new Shot(x, y + (height/2)));
    }

    public void load() {
        ImageIcon reference = new ImageIcon("res/player.png");
        image = reference.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void update() {
        if(y <= 0) {
            y+=5;
        }else if(y >= 330) {
            y-=5;
        }
        y += velocityY;
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            velocityY = -4;
        }else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            velocityY = 4;
        }
    }

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            velocityY = 0;
        }else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            velocityY = 0;
        }else if(key == KeyEvent.VK_SPACE) {
            shoot();
        }
    }


}
