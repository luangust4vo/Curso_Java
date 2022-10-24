package Models;

import javax.swing.*;
import java.awt.*;

public class Shot {

    Image image;

    int x;
    int y;

    int velocityX;

    int width;
    int height;

    boolean visible;

    int max_X;

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;

        visible = true;
        max_X = 300;
        velocityX = 4;
    }

    public void load() {
        ImageIcon reference = new ImageIcon("res/shot.png");
        image = reference.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public void update() {
        x += velocityX;
        if(x >= max_X) {
            visible = false;
        }
    }
}
