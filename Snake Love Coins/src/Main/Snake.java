package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Snake implements KeyListener {

    private Game game;

    BufferedImage snakeImage;
    BufferedImage snakeHeaderImage;

    private boolean check = true;

    public boolean isCheck(){
        return  check;
    }
    public void setCheck(boolean check){

        this.check = check;
    }

    private int[] snakeXLength = new int[750];
    private  int[] snakeYLength = new int[750];
    private int lengthOfSnake = 3;

    private  int location = 0;

    private boolean up = false;
    private boolean down = false;
    private boolean right = true;
    private boolean left = false;


    public void setLengthOfSnakePlus(){
        this.lengthOfSnake++;
    }

    public void setLengthOfSnakeMinus(){
        if(this.lengthOfSnake > 3)
            this.lengthOfSnake--;
    }

    public boolean collisionApple(){
        return game.coin.getBounds().intersects(getBounds());
    }
    public boolean collisionCarrot(){
        return game.carrot.getBounds().intersects(getBounds());
    }


    public Rectangle getBounds(){
        return new Rectangle(snakeXLength[0], snakeYLength[0], snakeImage.getWidth(), snakeImage.getHeight());
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(location == 0) {
            snakeXLength[0] = 200;
            snakeYLength[0] = 100;
            location++;
        }
        //g2.drawImage(snakeImage, snakeXLength[0], snakeYLength[0], null);
        if(right == true && check){

            for(int r = lengthOfSnake-1; r >= 0 ; r--){
                snakeYLength[r+1] = snakeYLength[r];
            }
            for(int r = lengthOfSnake; r >= 0 ; r--){
                if(r==0) {
                    snakeXLength[r] = snakeXLength[r]+45;
                }
                else{
                    snakeXLength[r] = snakeXLength[r-1];
                }
                if(snakeXLength[r] > 850){
                    game.setGameOver(false);
                }
            }
        }
        for(int i = 0 ; i < lengthOfSnake ; i++){

            if(right && check) {
                if (i == 0)
                    g2.drawImage(snakeHeaderImage, snakeXLength[i], snakeYLength[i], null);

                else {
                    g2.drawImage(snakeImage, snakeXLength[i], snakeYLength[i], null);
                }
            }
        }
        //********************************************************************







        //********************************************************************
        if(right && !check){
            for(int r = lengthOfSnake-1 ; r >= 0 ; r--){
                snakeYLength[r+1] = snakeYLength[r];
            }
            for(int r = lengthOfSnake ; r >= 0 ; r--){
                if(r == 0){
                    snakeXLength[r] = snakeXLength[r] + 45;
                }
                else {
                    snakeXLength[r] = snakeXLength[r-1];
                }
                if(snakeXLength[r] > 870){
                    game.setGameOver(false);
                }
            }
        }
        if(left && !check){
            for(int r = lengthOfSnake-1 ; r >= 0 ; r--){
                snakeYLength[r+1] = snakeYLength[r];
            }
            for(int r = lengthOfSnake ; r >= 0 ; r--){
                if(r == 0){
                    snakeXLength[r] = snakeXLength[r] - 45;
                }
                else {
                    snakeXLength[r] = snakeXLength[r-1];
                }
                if(snakeXLength[r] < -30){
                    game.setGameOver(false);
                }
            }
        }
        if(down && !check){
            for(int r = lengthOfSnake-1 ; r >= 0 ; r--){
                snakeXLength[r+1] = snakeXLength[r];
            }
            for(int r = lengthOfSnake ; r >= 0 ; r--){
                if(r == 0){
                    snakeYLength[r] = snakeYLength[r] + 45;
                }
                else {
                    snakeYLength[r] = snakeYLength[r-1];
                }
                if(snakeYLength[r] > 550){
                    game.setGameOver(false);
                }
            }
        }
        if(up && !check){
            for(int r = lengthOfSnake-1 ; r >= 0 ; r--){
                snakeXLength[r+1] = snakeXLength[r];
            }
            for(int r = lengthOfSnake ; r >= 0 ; r--){
                if(r == 0){
                    snakeYLength[r] = snakeYLength[r] - 45;
                }
                else {
                    snakeYLength[r] = snakeYLength[r-1];
                }
                if(snakeYLength[r] < -20){
                    game.setGameOver(false);
                }
            }
        }
    //**********************************************************************
        for(int i = 0; i < lengthOfSnake ; i++){
            if( i == 0 && right && !check){
                g2.drawImage(snakeHeaderImage, snakeXLength[i], snakeYLength[i], null);
            }
            if(i == 0 && left && !check){
                g2.drawImage(snakeHeaderImage, snakeXLength[i], snakeYLength[i], null);
            }
            if(i == 0 && up && !check){
                g2.drawImage(snakeHeaderImage, snakeXLength[i], snakeYLength[i], null);
            }
            if(i == 0 && down && !check){
                g2.drawImage(snakeHeaderImage, snakeXLength[i], snakeYLength[i], null);
            }
            if( i != 0 && !check){
                g2.drawImage(snakeImage, snakeXLength[i], snakeYLength[i], null);
            }
        }

        for(int i = 1 ; i < lengthOfSnake; i++){
            if(snakeXLength[i] == snakeXLength[0] && snakeYLength[i] == snakeYLength[0])
                game.setGameOver(false);
        }

    }
//****************************************************************************
    public Snake(Game game){
        this.game = game;

        try{
            snakeImage = ImageIO.read(new File("snakeImage.png"));
            snakeHeaderImage = ImageIO.read(new File("snakeHead.png"));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }


    public void addNotify(){

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT  && !left){
            down = false;
            up = false;
            right = true;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT  && !right){
            down = false;
            up = false;
            left = true;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN  && !up){
            down = true;
            left = false;
            right = false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP  && !down){
            left = false;
            up = true;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}
