package tests.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static task.one.ArcCos.arccos;


class ArcCosTest{
    double delta = 0.01;

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10})
    public void negativeInt(int value) {
        Assertions.assertEquals(Math.acos(value), arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    public void positiveInt(int value) {
        Assertions.assertEquals(Math.acos(value), arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -0.15, -0.31, -0.665, -0.7001, -0.95})
    public void negativeAllowableDouble(double value) {
        Assertions.assertEquals(Math.acos(value), arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.15, 0.31, 0.665, 0.7001, 0.95})
    public void positiveAllowableDouble(double value) {
        Assertions.assertEquals(Math.acos(value), arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.0001, -0.000001, -0.029, 0.0001, 0.000001, 0.000099})
    public void nearZeroDouble(double value) {
        Assertions.assertEquals(Math.acos(value), arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.9, -0.91, -0.99, -0.9901, -0.999999, -1.000001})
    public void negativeNearOneDouble(double value) {
        Assertions.assertEquals(Math.acos(value), arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.9, 0.91, 0.99, 0.9901, 0.999999, 1.000001})
    public void positiveNearOneDouble(double value) {
        Assertions.assertEquals(Math.acos(value), arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Integer.MAX_VALUE, Integer.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    public void bigData(double value) {
        Assertions.assertEquals(Math.acos(value), arccos(value), delta);
    }
}