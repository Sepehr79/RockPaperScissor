package Main;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        Game game = new Game();
        add(game);
        addKeyListener(game);
        setTitle("Snake game");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
