package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Stage extends JPanel implements ActionListener {

    Image image;
    Player player;
    Timer timer;
    ArrayList<Enemy> enemies;
    boolean inGame = true;

    public Stage() {
        setFocusable(true);
        setDoubleBuffered(true);

        enemies = new ArrayList<>();

        ImageIcon reference = new ImageIcon("res/background.png");
        image = reference.getImage();

        player = new Player();
        player.load();

        addKeyListener(new Keyboard(player));

        loadEnemies();

        timer = new Timer(3, this);
        timer.start();
    }

    public void checkCollision(){
        Rectangle playerBounds = player.getBounds();
        for(Enemy enemy : enemies){
            Rectangle enemyBounds = enemy.getBounds();
            if(playerBounds.intersects(enemyBounds)){
                inGame = false;
            }
        }

        ArrayList<Shot> shots = player.shots;
        for(Shot shot : shots){
            Rectangle shotBounds = shot.getBounds();
            for(Enemy enemy : enemies){
                Rectangle enemyBounds = enemy.getBounds();
                if(shotBounds.intersects(enemyBounds)){
                    enemy.setVisible(false);
                    shot.visible = false;
                }
            }
        }
    }

    public void loadEnemies(){
        for(int i = 0; i < 100; i++){
            int x = (int) (Math.random()  * 8000 + 1024);
            int y = (int) (Math.random() * 650);

            Enemy enemy = new Enemy(x, y);
            enemies.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(image, 0, 0, null);
        if(inGame){
            ArrayList<Shot> shots = player.shots;

            for(Shot shot : shots) {
                shot.load();
                graphics2D.drawImage(shot.image, shot.x, shot.y, this);
            }
            graphics2D.drawImage(player.image, player.x, player.y, this);

            for(Enemy enemy : enemies){
                enemy.load();
                graphics2D.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
            }
        } else{
            int x = 1042/10;
            int y = 728/4;

            String text = "Game Over";
            graphics2D.setFont(new Font("Public Sans", Font.BOLD, 68));
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(text, x, y);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        for (int i = 0; i < player.shots.size(); i++) {
            Shot shot = player.shots.get(i);
            if(shot.visible == true) {
                shot.update();
            }else {
                player.shots.remove(shot);
            }
        }

        for(int i = 0; i < enemies.size(); i++){
            Enemy enemy = enemies.get(i);
            if(enemy.isVisible()){
                enemy.update();
            } else{
                enemies.remove(enemy);
            }
        }

        checkCollision();
        repaint();
    }
}
