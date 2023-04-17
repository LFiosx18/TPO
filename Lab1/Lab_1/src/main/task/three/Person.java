package task.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Person {
    private final String name;
    private final ArrayList<String> feelings;
    private final ArrayList<Action> actions;
    public BodyParts bodyParts;

    public Person(String name) {
        this.name = name;
        this.feelings = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.bodyParts = new BodyParts();
    }

    public String getName() {
        return name;
    }

    public void addFeeling(String feeling) {
        feelings.add(name + ' ' + feeling);
    }

    public ArrayList<String> getFeelings() {
        return feelings;
    }

    public void addAction(String ...action) {
        StringBuilder s = new StringBuilder();
        for (String i: action)
            s.append(i).append(' ');
        actions.add(new Action(s.toString()));
    }

    public StringBuilder getActions() {
        StringBuilder s = new StringBuilder();
        for (Action action: actions) {
            s.append(action.getDescription());
            s.append('\n');
        }
        return s;
    }

    public String toString() {
        return "Человек по имени " + name;
    }
}
