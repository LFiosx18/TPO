package task.two;

import java.util.*;

public class HashTable<T extends Number> {
    final int MAX_COUNT = 100;
    final int MAX_VALUE = 1000;
    private Vector<SortedMap<Double, Integer>> collection;

    private int size;
    public HashTable() {
        this.collection = new Vector<>();
    }

    public double[] sort(double[] arr) {
        if (arr == null)
            return null;
        this.size = arr.length;
        for (int i = 0; i < size; i++) {
            collection.add(new TreeMap<>());
        }
        int newSize = size;

        for (double el:arr) {
            if (Math.abs(el) > MAX_VALUE) {
                System.err.println("Number " + el + " greater than the maximum value");
                newSize--;
                continue;
            }
            int index = index(el);
            if (collection.get(index).containsKey(el)) {
                collection.get(index).put(el, collection.get(index).get(el) + 1);
            } else
                collection.get(index).put(el, 1);
        }
        double[] sortArr = new double[newSize];
        int i=0;
        for (SortedMap<Double,Integer> map: collection) {
            for (Double val: map.keySet()) {
                int count = map.get(val);
                for (int j=0; j<count; j++) {
                    sortArr[i++] = val;
                }
            }
        }
        collection.clear();
        return sortArr;
    }

    private int index(double val) {
        return (int)Math.floor(Math.abs(val)*size/(MAX_VALUE+1));
    }

}
