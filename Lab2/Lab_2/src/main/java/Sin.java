public class Sin {
    public double sin(double x) {
        int picount = (int)(x/(2*Math.PI));
        x -= picount * 2 * Math.PI;

        if (x==0 || x==Math.PI || x==-Math.PI)
            return 0;

        int n = 0;
        double tmp = x;
        double res = tmp;
        while (Math.abs(tmp) > 0.0000001 && n < 100000) {
            n++;
            tmp = -tmp * x * x / (2 * n * (2 * n + 1));
            res += tmp;
        }

        if (res > 1 || res < -1) {
            return Double.NaN;
        }

        return res;
    }
}
