package Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreSaver implements Serializable {
    ArrayList<Integer> scores = new ArrayList<>();
    public ArrayList<Integer> getScores(){
        return this.scores;
    }
    public void addScore(int number){
        scores.add(number);
        Collections.sort(scores);
        Collections.reverse(scores);
    }
}
