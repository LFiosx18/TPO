package tests.two;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.two.HashTable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    static HashTable<Number> collection;

    @BeforeEach
    void init() {
        collection = new HashTable<>();
    }

    @Test
    void sort() {
        double[] arr = {520, 999, 101, 1, 10, 54, 647, 17};
        double[] sortArr = {1, 10, 17, 54, 101, 520, 647, 999};
        double[] newArr = collection.sort(arr, false, -1);
        assertArrayEquals(sortArr, newArr);
    }

    @Test
    void arrayRepead() {
        double[] arr = {520, 17, 0, 999, 101, 1, 10, 54, 101, 647, 17, 0, 0, 17};
        double[] sortArr = {0, 0, 0, 1, 10, 17, 17, 17, 54, 101, 101, 520, 647, 999};
        double[] newArr = collection.sort(arr, false, -1);
        assertArrayEquals(sortArr, newArr);
    }

    @Test
    void maxVals() {
        double[] arr = {1000, 999, -10000.1, 1001, -1000, -999, -10000.1, -10000, 1000.1, -10000.1};
        double[] sortArr = {-10000.1, -10000.1, -10000.1, -10000, -1000, -999, 999, 1000, 1000.1, 1001};
        double[] newArr = collection.sort(arr, false, -1);
        assertArrayEquals(sortArr, newArr);
    }

    @Test
    void checkNull() {
        double[] arr = null;
        double[] newArr = collection.sort(arr, false, -1);
        assertArrayEquals(null, newArr);
    }

    @Test
    void checkOneEl() {
        double[] arr = {101.5};
        double[] sortArr = {101.5};
        double[] newArr = collection.sort(arr, false, -1);
        assertArrayEquals(sortArr, newArr);
    }

    @Test
    void checkBigData() {
        double[] arr = {Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Integer.MAX_VALUE, Double.POSITIVE_INFINITY, 101};
        double[] sortArr = {Double.MIN_VALUE, 101};
        double[] newArr = collection.sort(arr, false, -1);
        assertArrayEquals(null, newArr);
    }

    @Test
    void checkCollision_1() {
        double[] arr = {520, 999, 101, 1, 10, 54, 647, 17};
        double[] restArr = {1, 101};
        assertArrayEquals(restArr, collection.sort(arr, false, 1));
    }

    @Test
    void checkCollision_5() {
        double[] arr = {520, 999, 101, 1, 10, 54, 647, 17};
        double[] restArr = {1.0, 10.0, 54.0, 101.0};
        assertArrayEquals(restArr, collection.sort(arr, false, 5));
    }
}