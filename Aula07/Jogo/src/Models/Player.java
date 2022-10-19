package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    //Sprite
    Image image;

    //Posicionamento nos eixos x e y
    int x;
    int y;

    //Variável que representa a velocidade do player no eixo Y(para movimentação)
    int velocityY;

    //Propriedades do sprite do jogador
    int width;
    int height;

    public Player(){
        x = 100;
        y = 100;
    }

    public void load(){
        ImageIcon reference = new ImageIcon("res/player.png");
        image = reference.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void update(){
        if(y <= 0){
            y += 10;
        } else if (y >= 655) {
            y -= 10;
        }
        y += velocityY;
    }

    /*
    * Métodos referentes aos eventos do teclado. No caso, o pressionamento das teclas CIMA e BAIXO
    * */
    public void keyDown(KeyEvent event){
        int key = event.getKeyCode();

        if(key == KeyEvent.VK_UP){
            velocityY = -4;
        } else if (key == KeyEvent.VK_DOWN) {
            velocityY = 4;
        }
    }

    public void keyUp(KeyEvent event){
        int key = event.getKeyCode();

        if(key == KeyEvent.VK_UP){
            velocityY = 0;
        } else if (key == KeyEvent.VK_DOWN) {
            velocityY = 0;
        }
    }
}
