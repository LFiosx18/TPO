package task.three;

import java.util.ArrayList;
import java.util.Objects;

public class BodyParts {
    ArrayList<String> bodyParts;

    public BodyParts() {
        this.bodyParts = new ArrayList<>();
    }

    public String getBodyPart(String bodyPart) {
        for (String myBodyPart: bodyParts) {
            if (Objects.equals(bodyPart, myBodyPart)) {
                return myBodyPart;
            }
        }
        return "Часть тела не найдена";
    }

    public void bodyPartsAdd(String part) {
        bodyParts.add(part);
    }
}
