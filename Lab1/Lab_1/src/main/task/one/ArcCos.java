package task.one;

import static java.lang.Math.*;

public class ArcCos {
    public static double arccos(double x) {
        if (x > 1 || x < -1) {
            return Double.NaN;
        }

        int n = 1;
        double tmp = pow(x, n * 2 + 1) / (2 * n * (2 * n + 1));
        double res = tmp;
        n++;
        while (abs(tmp) > 0.000001 && n<10000) {
            tmp = tmp * pow(x, 2) * pow((2 * n - 1), 2) / ((2 * n) * (2 * n + 1));
            res += tmp;
            n++;
        }
        res += x;
        return PI / 2 - res;
    }
}
