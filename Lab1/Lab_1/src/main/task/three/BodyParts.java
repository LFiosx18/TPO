package task.three;

import java.util.ArrayList;
import java.util.Locale;

public class BodyParts {
    private final FaceParts[] fp;
    public ArrayList<String> parts;

    public BodyParts() {
        this.parts = new ArrayList<>();
        fp = FaceParts.values();
    }

    public String addBodyPart(Person person, String bp) {
        for (String s: parts) {
            if (s.toLowerCase().equals(bp.toLowerCase()))
                return "Часть тела " + bp + " уже существует";
        }
        if (bp.toLowerCase().contains("голова")) {
            if (person.heads == null) {
                person.heads = new ArrayList<>();
            }
            person.heads.add(new Head(bp));
        }
        for (FaceParts f: fp) {
            if (bp.toLowerCase().equals(f.getFacePart()))
                return "Часть тела \"" + bp + "\" должна быть добавлена к голове";
        }
        parts.add(bp);
        return "У " + person.getName() + " есть " + bp;
    }

    public String addFacePart(Person person, String headName, String facePart) {
        if (person.heads == null)
            return person.getName() + " не имеет головы";
        for (Head head: person.heads) {
            if (head.getHeadName().equals(headName)) {
                for (FaceParts f: fp) {
                    if (facePart.toLowerCase().equals(f.getFacePart())) {
                        head.addFacePart(facePart);
                        parts.add(facePart);
                        return "У существа " + person.getName() + " в " + headName + " появился " + facePart;
                    }
                }
                return "Неопознанная часть лица..";
            }
        }
        return "Неопознанная голова";
    }

    public String getBodyPart(String bp) {
        for (String b: parts) {
            if (b.toLowerCase().contains(bp)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder partsToString = new StringBuilder();
        for (String bp: parts) {
            partsToString.append(bp);
            partsToString.append(' ');
        }
        return partsToString.toString();
    }
}
