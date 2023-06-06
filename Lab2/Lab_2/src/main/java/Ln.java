public class Ln {
    public double ln(double x) {
        if (x<=0)
            return Double.NaN;

        int n=1;
        double tmp;
        double res;

        if (x <= 2) {
            tmp = x-1;
            res = tmp;
            while (Math.abs(tmp) > 0.0000001 && n < 100000) {
                n++;
                tmp *= -(x-1) * (n-1)/n;
                res += tmp;
            }
        }
        else {
            x /= x-1;
            tmp = 1/x;
            res = tmp;
            while (Math.abs(tmp) > 0.0000001 && n < 100000) {
                n++;
                tmp *= (n-1)/(n*x);
                res += tmp;
            }
        }
        return res;
    }
}
