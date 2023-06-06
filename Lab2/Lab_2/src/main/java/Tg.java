public class Tg {
    private final Sin sin;
    private final Cos cos;

    public Tg(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public Tg() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public double tg(double x) {
        double cosVal = cos.cos(x);
        double sinVal = sin.sin(x);
        if (Double.isNaN(sinVal) || Double.isNaN(cosVal) || cosVal == 0)
            return Double.NaN;
        return sinVal / cosVal;
    }
}
