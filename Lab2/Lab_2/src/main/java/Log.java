public class Log {
    private final Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public Log() {
        this.ln = new Ln();
    }

    public double log(double a, double b) {
        double lnA = ln.ln(a);
        double lnB = ln.ln(b);

        if (lnA == 1)
            return Double.NaN;
        return lnB/lnA;
    }
}
