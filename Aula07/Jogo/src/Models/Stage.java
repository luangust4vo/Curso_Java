package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stage extends JPanel implements ActionListener {

    //Variável para a imagem de fundo(Background)
    Image image;
    //Variável para o sprite do player
    Player player;
    Timer timer;

    public Stage(){
        //Estes dois métodos melhoram o desempenho do game
        setFocusable(true);
        setDoubleBuffered(true);

        //Atribuição da variável de imagem de fundo
        ImageIcon reference = new ImageIcon("res/background.png");
        image = reference.getImage();

        //Instanciação do jogador
        player = new Player();
        player.load();

        addKeyListener(new KeyBoard(player));

        timer = new Timer(3, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        //Down Cast de 'Graphics' para 'Graphics2D'
        Graphics2D graficos2D = (Graphics2D) g;

        //Desenhando os sprites na janela destinada ao jogo
        graficos2D.drawImage(image, 0, 0, null); //Background
        graficos2D.drawImage(player.image, player.x, player.y, this); //Jogador
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }
}
