package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SideMenus.Level;
import SideMenus.ScoresMenu;

public class GameMenu extends JFrame implements ActionListener {
    JButton start;
    JButton scores;
    JButton setting;
    JLabel picture;
    public GameMenu(){
        setTitle("Snake Love Apples");
        setSize(300, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        picture = new JLabel(new ImageIcon("snake.png"));
        picture.setBounds(50, 0, 200, 200);
        add(picture);

        start = new JButton("Start");
        start.setBounds(100, 210, 100, 40);
        add(start);
        start.addActionListener(this);
        scores = new JButton("Scores");
        scores.setBounds(100, 260, 100, 40);
        add(scores);
        scores.addActionListener(this);
        setting = new JButton("Setting");
        setting.setBounds(100, 310, 100, 40);
        add(setting);
        setting.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == start) {
            new GameFrame();
            this.dispose();
        }
        if(actionEvent.getSource() == scores){
            new ScoresMenu();
        }
        if(actionEvent.getSource() == setting){
            new Level();
        }
    }
}
