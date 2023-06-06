package task.three;

import java.util.ArrayList;

public class Feeling {
    ArrayList<String> feelings;

    public Feeling() {
        this.feelings = new ArrayList<>();
    }

    public void addFeeling(String feel) {
        feelings.add(feel);
    }
}
