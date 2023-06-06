package task.three;

public enum FaceParts {
    EYES("глаза"),
    NOSE("нос"),
    TEETH("зубы"),
    SMILE("челюсть");

    private final String facePart;
    FaceParts(String facePart) {
        this.facePart = facePart;
    }

    public String getFacePart() {
        return facePart;
    }
}
