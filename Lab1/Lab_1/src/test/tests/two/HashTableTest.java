package tests.two;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.two.HashTable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    static HashTable<Number> collection;

    @BeforeAll
    static void init() {
        collection = new HashTable<>();
    }

    @Test
    void sort() {
        double[] arr = {520, 999, 101, 1, 10, 54, 647, 17};
        double[] sortArr = {1, 10, 17, 54, 101, 520, 647, 999};
        double[] newArr = collection.sort(arr);
        assertArrayEquals(sortArr, newArr);
    }

    @Test
    void arrayRepead() {
        double[] arr = {520, 17, 0, 999, 101, 1, 10, 54, 101, 647, 17, 0, 0, 17};
        double[] sortArr = {0, 0, 0, 1, 10, 17, 17, 17, 54, 101, 101, 520, 647, 999};
        double[] newArr = collection.sort(arr);
        System.out.println(Arrays.toString(newArr));
        assertArrayEquals(sortArr, newArr);
    }

    @Test
    void maxVals() {
        double[] arr = {1000, 999, 1001, -1000, -999};
        double[] sortArr = {-1000, -999, 999, 1000};
        double[] newArr = collection.sort(arr);
        assertArrayEquals(sortArr, newArr);
    }

    @Test
    void checkNull() {
        double[] arr = null;
        double[] newArr = collection.sort(arr);
        System.out.println(Arrays.toString(newArr));
        assertArrayEquals(null, newArr);
    }

    @Test
    void checkOneEl() {
        double[] arr = {101.5};
        double[] sortArr = {101.5};
        double[] newArr = collection.sort(arr);
        assertArrayEquals(sortArr, newArr);
    }
}