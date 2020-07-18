package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Carrot {
    Random rand = new Random();

    private BufferedImage carrotImage;
    private int XPos;
    private int yPos;

    private Game game;

    public void XYRandom() {
        this.XPos = rand.nextInt(800);
        this.yPos = rand.nextInt(500);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(carrotImage, XPos, yPos, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(XPos, yPos, carrotImage.getWidth(), carrotImage.getHeight());
    }

    public Carrot() {
        try {
            carrotImage = ImageIO.read(new File("carrot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
