package SideMenus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Main.*;

public class Level extends JFrame implements ActionListener {
    JRadioButton hard;
    JRadioButton normal;
    JRadioButton easy;
    ButtonGroup buttonGroup;
    JButton ok;

    public Level(){
        setTitle("Select Level");
        setSize(200, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        hard = new JRadioButton("Hard");
        hard.setBounds(70, 20, 60, 20);
        add(hard);
        normal = new JRadioButton("Normal");
        normal.setBounds(70, 40, 80, 20);
        add(normal);
        easy = new JRadioButton("Easy");
        easy.setBounds(70, 60, 60, 20);
        add(easy);

        if (Game.level == 200)
            easy.setSelected(true);
        else if (Game.level == 120)
            normal.setSelected(true);
        else if(Game.level == 60)
            easy.setSelected(true);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(hard);
        buttonGroup.add(normal);
        buttonGroup.add(easy);

        ok = new JButton("Set");
        ok.setBounds(70, 160, 60, 20);
        add(ok);
        ok.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(hard.isSelected())
            Game.level = 60;
        else if (normal.isSelected())
            Game.level = 120;
        else if (easy.isSelected())
            Game.level = 200;
        this.dispose();
    }
}
