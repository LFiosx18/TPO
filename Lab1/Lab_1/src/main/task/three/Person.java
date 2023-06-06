package task.three;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private final String name;
    private final Feeling feeling;
    public BodyParts bodyParts;
    public ArrayList<Head> heads;
    public ArrayList<Action> actions;

    public Person(String name) {
        this.name = name;
        this.feeling = new Feeling();
        this.bodyParts = new BodyParts();
        this.actions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String addBodyPart(String bp) {
        return bodyParts.addBodyPart(this, bp);
    }

    public String addFacePart(String fp, String h) {
        return bodyParts.addFacePart(this, h, fp);
    }

    public String getBodyParts() {
        return bodyParts.toString();
    }

    public String addAction(String act) {
        Action newAction = new Action(act);
        actions.add(newAction);
        return name + ' ' + newAction.getAciton();
    }

    public String addAction(String act, Person p) {
        Action newAction = new Action(act + ' ' + p.getName());
        actions.add(newAction);
        return name + ' ' + newAction.getAciton();
    }

    public String addAction(String ... act) {
        StringBuilder acts = new StringBuilder();
        for (String s: act) {
            acts.append(s).append(' ');
        }
        Action newAction = new Action(acts.toString());
        actions.add(newAction);
        return name + ' ' + newAction.getAciton();
    }

    public String showActions() {
        StringBuilder result = new StringBuilder();
        for (Action act: actions){
            result.append(name).append(' ').append(act.getAciton()).append(' ');
        }
        return result.toString();
    }

    public String addFeeling(String feel) {
        if (bodyParts.getBodyPart("голова") != null) {
            feeling.addFeeling(feel);
            return name + ' ' + feel;
        }
        return "У существа " + name + " нет головы, он не может испытывать чувтсва!";
    }

    public String addFeeling(String bodyPart, String feel) {
        if (bodyParts.getBodyPart(bodyPart) != null) {
            for (Head h: heads) {
                if (Objects.equals(h.getHeadName(), bodyPart)) {
                    h.addFeelingToHead(feel);
                    return bodyPart + ' ' + feel;
                }
            }
            return "Такой головы не существует";
        }
        return "Такой части тела не найдено";
    }

    @Override
    public String toString() {
        return "Существо по имени " + name;
    }
}
