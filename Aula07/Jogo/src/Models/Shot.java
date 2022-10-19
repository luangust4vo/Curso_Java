package Models;

import javax.swing.*;
import java.awt.*;

public class Shot {

    //Sprite do tiro
    Image image;

    //Posicionamento da bala os eixos X e Y
    int x;
    int y;

    //Propriedades do sprite do tiro
    int width;
    int height;
    boolean visible;

    //Distância máxima do tiro
    int max_X;

    public Shot(){
        this.x = x;
        this.y = y;
    }

    public void load(){
        ImageIcon reference = new ImageIcon("res/shot.png");
        image = reference.getImage();
    }
}
