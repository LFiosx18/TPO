import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {
    double eps = 0.1;

    static Sin sinMock;
    static Cos cosMock;
    static Tg tgMock;
    static Ctg ctgMock;
    static Csc cscMock;
    static Ln lnMock;
    static Log logMock;

    static Reader sinIn;
    static Reader cosIn;
    static Reader tgIn;
    static Reader ctgIn;
    static Reader cscIn;
    static Reader lnIn;
    static Reader log2In;
    static Reader log3In;
    static Reader log5In;
    static Reader log10In;

    @BeforeAll
    static void init() {
        sinMock = Mockito.mock(Sin.class);
        cosMock = Mockito.mock(Cos.class);
        tgMock = Mockito.mock(Tg.class);
        ctgMock = Mockito.mock(Ctg.class);
        cscMock = Mockito.mock(Csc.class);
        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);

        try {
            sinIn = new FileReader("src/main/resources/sin.csv");
            cosIn = new FileReader("src/main/resources/cos.csv");
            tgIn = new FileReader("src/main/resources/tg.csv");
            ctgIn = new FileReader("src/main/resources/ctg.csv");
            cscIn = new FileReader("src/main/resources/csc.csv");
            lnIn = new FileReader("src/main/resources/ln.csv");
            log2In = new FileReader("src/main/resources/log2.csv");
            log3In = new FileReader("src/main/resources/log3.csv");
            log5In = new FileReader("src/main/resources/log5.csv");
            log10In = new FileReader("src/main/resources/log10.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record: records)
                Mockito.when(sinMock.sin(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(cosIn);
            for (CSVRecord record : records)
                Mockito.when(cosMock.cos(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(tgIn);
            for (CSVRecord record : records)
                Mockito.when(tgMock.tg(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(ctgIn);
            for (CSVRecord record : records)
                Mockito.when(ctgMock.ctg(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(cscIn);
            for (CSVRecord record : records)
                Mockito.when(cscMock.csc(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records)
                Mockito.when(lnMock.ln(Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records)
                Mockito.when(logMock.log(2, Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records)
                Mockito.when(logMock.log(3, Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records)
                Mockito.when(logMock.log(5, Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));
            records = CSVFormat.DEFAULT.parse(log10In);
            for (CSVRecord record : records)
                Mockito.when(logMock.log(10, Double.parseDouble(record.get(0)))).thenReturn(Double.valueOf(record.get(1)));

        }
        catch (IOException ex) {
            System.err.println("IOException");
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testSystemWithMocks(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, ctgMock, cscMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithSec(double value, double expected) {
        Function function = new Function(new Sin(), cosMock, tgMock, ctgMock, cscMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithSecDeeper(double value, double expected) {
        Function function = new Function(sinMock, new Cos(new Sin()), tgMock, ctgMock, cscMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithLn(double value, double expected) {
        Function function = new Function(sinMock, new Cos(sinMock), tgMock, ctgMock, cscMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithLog(double value, double expected) {
        Function function = new Function(sinMock, cosMock, new Tg(), ctgMock, cscMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithLogDeeper(double value, double expected) {
        Function function = new Function(sinMock, cosMock, new Tg(new Sin(), new Cos()), ctgMock, cscMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithTanDeeper(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, new Ctg(), cscMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithTanDeeperAndCosDeeper(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, new Ctg(new Sin(), new Cos()), cscMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithCosDeeper(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, ctgMock, new Csc(), lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithCot(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, ctgMock, new Csc(new Sin()), lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithCotDeeper(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, ctgMock, new Csc(sinMock), lnMock, logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithCotDeeperAndCosDeeper(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, ctgMock, cscMock, new Ln(), logMock);
        Assertions.assertEquals(expected, function.func(value), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithSin(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, ctgMock, cscMock, lnMock, new Log());
        Assertions.assertEquals(expected, function.func(value), eps*100);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testWithCsc(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tgMock, ctgMock, cscMock, lnMock, new Log(new Ln()));
        Assertions.assertEquals(expected, function.func(value), eps*100);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "systemIn.csv")
    void testReal(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(), new Tg(), new Ctg(), new Csc(), new Ln(), new Log(new Ln()));
        Assertions.assertEquals(expected, function.func(value), eps*100);
    }
    private static double normalization_x(double x) {
        int picount = (int)(x/(2*Math.PI));
        return x - picount * 2 * Math.PI;
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10, -Math.PI, -1, -0.0001, 0, 0.00001, 3.14, 9.99, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE})
    public void sinTest(double param) {
        Sin sin = new Sin();
        Assertions.assertEquals(Math.sin(param), sin.sin(param), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10, -Math.PI, -1, -0.0001, 0, 0.00001, 3.14, 9.99, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE})
    public void cosTest(double param) {
        Cos cos = new Cos();
        Assertions.assertEquals(Math.cos(param), cos.cos(param), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10, -Math.PI, -1, -0.0001, 0, 0.00001, 3.14, 9.99, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE})
    public void tgTest(double param) {
        Tg tg = new Tg();
        Assertions.assertEquals(Math.tan(param), tg.tg(param), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10, -Math.PI, -1, -0.0001, 0, 0.00001, 3.11, 9.99, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE})
    public void ctgTest(double param) {
        double newx = normalization_x(param);
        double trueVal = 1/Math.tan(param);
        Ctg ctg = new Ctg();
        if (Math.abs(param) % (2*Math.PI) == Math.PI)
            if ((newx > -Math.PI/2 && newx < Math.PI/2) || (newx+2*Math.PI > -Math.PI/2 && newx+2*Math.PI < Math.PI/2) || (newx-2*Math.PI > -Math.PI/2 && newx-2*Math.PI < Math.PI/2))
                trueVal = Double.POSITIVE_INFINITY;
            else
                trueVal = Double.NEGATIVE_INFINITY;
        Assertions.assertEquals(trueVal, ctg.ctg(param), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10, -Math.PI, -1, -0.0001, 0, 0.00001, 3.11, 9.99, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE})
    public void cscTest(double param) {
        double newx = normalization_x(param);
        double trueVal = 1/Math.sin(newx);
        Csc csc = new Csc();
        if (Math.abs(newx) % (2*Math.PI) == Math.PI)
            trueVal = Double.POSITIVE_INFINITY;
        Assertions.assertEquals(trueVal, csc.csc(newx), eps);
    }

}