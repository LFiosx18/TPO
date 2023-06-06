public class Cos {
    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public Cos() {
        this.sin = new Sin();
    }

    public double cos(double x) {
        int picount = (int)(x/(2*Math.PI));
        x -= picount * 2 * Math.PI;

        double res = Math.sqrt(1 - Math.pow(sin.sin(x), 2));
        if ((x > -Math.PI/2 && x < Math.PI/2) || (x+2*Math.PI > -Math.PI/2 && x+2*Math.PI < Math.PI/2) || (x-2*Math.PI > -Math.PI/2 && x-2*Math.PI < Math.PI/2)) {
            return res;
        }
        else {
            return -res;
        }

    }
}
