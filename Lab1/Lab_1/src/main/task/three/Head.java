package task.three;

public class Head extends BodyParts {
    private final Feeling feelings;
    private final String headName;

    public Head(String name) {
        this.headName = name;
        this.feelings = new Feeling();
    }

    public void addFeelingToHead(String feel) {
        feelings.addFeeling(feel);
    }

    public void addFacePart(String fp) {
        this.parts.add(fp);
    }

    public String getHeadName() {
        return headName;
    }

}
