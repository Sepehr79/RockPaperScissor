package SideMenus;

import Helpers.FileHelper;
import Main.ScoreSaver;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ScoresMenu extends JFrame {
    FileHelper<ScoreSaver> fileHelper = new FileHelper<>();
    ScoreSaver scoreSaver;
    public ScoresMenu() {


        try {
            scoreSaver = fileHelper.readObject();
        } catch (Exception e) {
            scoreSaver = new ScoreSaver();
        }



        String[] header = {"Number", "Score"};
        String[][] scores = new String[scoreSaver.getScores().size()][2];
        for(int i = 0 ; i < scoreSaver.getScores().size() ; i++){
            for (int j = 0 ; j < 2 ; j++){
                if (j == 0)
                    scores[i][j] = String.valueOf(i+1);
                else
                    scores[i][j] = String.valueOf(scoreSaver.getScores().get(i));
            }
        }

        JTable table = new JTable(scores, header);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);

        setTitle("Best Scores:");
        setSize(200, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
