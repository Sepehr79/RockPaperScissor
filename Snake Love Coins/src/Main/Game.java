package Main;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import Helpers.FileHelper;

public class Game extends JPanel implements Runnable, KeyListener {

    public static int level = 120;
    private boolean gameOver = true;
    Thread snakeThread;
    Coin coin = new Coin();
    Carrot carrot = new Carrot();
    BufferedImage nature;
    Snake snake = new Snake(this);
    Player player = new Player(this);

    FileHelper<ScoreSaver> fileHelper = new FileHelper<ScoreSaver>();
    ScoreSaver scoreSaver;

    public void setGameOver(boolean gameOver){
        this.gameOver = gameOver;
    }

    @Override
    public void addNotify(){
        super.addNotify();
        snakeThread = new Thread(this);
        snakeThread.start();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(nature, 0, 0, null);
        snake.paint(g2);
        coin.paint(g2);
        carrot.paint(g2);

        g2.setColor(Color.BLACK);
        Font font = new Font("arial", Font.BOLD, 40);
        g2.setFont(font);
        g2.drawString("Your Score:", 30, 620);
        g2.drawString(String.valueOf(player.getScore()), 300, 620);

        if(!gameOver){
            g2.drawString("Game Over", 320, 300);
            g2.drawString("Press Enter", 318, 345);


            scoreSaver.addScore(player.getScore());

            try {
                fileHelper.writeObject(scoreSaver);
            } catch (IOException e) {
                e.printStackTrace();
            }

            addKeyListener(this);
        }

    }
    public void move(){
        player.getApplePos();
        player.getApple();
        player.getCarrotPos();
        player.getCarrot();
    }


    public Game(){
        try {
            nature = ImageIO.read(new File("nature.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            scoreSaver = fileHelper.readObject();
        } catch (Exception e) {
            scoreSaver = new ScoreSaver();
        }
        //music();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(gameOver) {
            snake.setCheck(false);
            snake.keyPressed(keyEvent);
        }
        else {
            if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                topFrame.dispose();
                new GameMenu();
            }
        }
    }



    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public static void music(){
        //new SimplePlayer();
    }

    @Override
    public void run() {
        int speed = level;
        long time_one = System.currentTimeMillis();
        boolean firstCheck = false;
        while (gameOver){
            if(firstCheck) {
                time_one = System.currentTimeMillis();
                firstCheck = false;
            }
            repaint();
            move();
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long time_two = System.currentTimeMillis();

            if(time_two - time_one > 20000) {
                if(speed - 20 > 0)
                    speed -= 20;
                firstCheck = true;
            }
        }
    }
}
