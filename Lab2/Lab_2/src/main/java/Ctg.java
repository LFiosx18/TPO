public class Ctg {
    private final Sin sin;
    private final Cos cos;

    public Ctg(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public Ctg() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public double ctg(double x) {
        double cosVal = cos.cos(x);
        double sinVal = sin.sin(x);
        if (sinVal == 0) {
            if (cosVal >=0)
                return Double.POSITIVE_INFINITY;
            return Double.NEGATIVE_INFINITY;
        }
        return cosVal / sinVal;
    }
}
