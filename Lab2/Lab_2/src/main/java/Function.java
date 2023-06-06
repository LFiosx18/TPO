import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;

public class Function {
    Sin sin;
    Cos cos;
    Tg tg;
    Ctg ctg;
    Csc csc;
    Ln ln;
    Log log;

    public Function() {
        this.sin = new Sin();
        this.cos = new Cos();
        this.tg = new Tg();
        this.ctg = new Ctg();
        this.csc = new Csc();
        this.ln = new Ln();
        this.log = new Log(ln);
    }

    public Function(Sin sin, Cos cos, Tg tg, Ctg ctg, Csc csc, Ln ln, Log log) {
        this.sin = sin;
        this.cos = cos;
        this.tg = tg;
        this.ctg = ctg;
        this.csc = csc;
        this.ln = ln;
        this.log = log;
    }

    public double func(double x) {
        if (x<=0)
            return (Math.pow((ctg.ctg(x)/tg.tg(x))/tg.tg(x), 3) / ((sin.sin(x)-csc.csc(x))+(tg.tg(x)-cos.cos(x)))) / tg.tg(x);
        return (Math.pow((log.log(10, x) * log.log(3, x)) * log.log(5, x), 2) * (((log.log(10, x) + ln.ln(x)) + ln.ln(x)) + log.log(3, x))) - Math.pow(log.log(2, x), 3);
    }

    public void writeCSV(double x, PrintWriter out) {
        double res = func(x);
        try{
            CSVPrinter printer = CSVFormat.DEFAULT.print(out);
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
