public class Csc {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public Csc() {
        this.sin = new Sin();
    }

    public double csc(double x) {
        double sinVal = sin.sin(x);
        if (sinVal == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return 1 / sinVal;
    }
}
