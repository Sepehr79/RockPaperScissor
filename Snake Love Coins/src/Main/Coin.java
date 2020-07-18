package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.io.File;

public class Coin {
    Random rand = new Random();

    private BufferedImage coinImage;
    private int XPos;
    private int yPos;

    private  Game game;

    public void XYRandom(){
        this.XPos = rand.nextInt(800);
        this.yPos = rand.nextInt(500);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(coinImage, XPos, yPos, null);
    }

    public Rectangle getBounds(){
        return new Rectangle(XPos, yPos, coinImage.getWidth(), coinImage.getHeight());
    }

    public Coin(){
        try {
            coinImage = ImageIO.read(new File("coinImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
