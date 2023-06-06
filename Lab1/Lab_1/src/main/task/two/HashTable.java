package task.two;

import java.util.*;

public class HashTable<T extends Number> {
    int MAX_COUNT = 100;
    double MAX_VALUE;
    double MIN_VALUE;
    private int size;

    Vector<Vector<Double>> collection;

    static int iter = -1;

    public double[] sort(double[] arr, boolean flag, int it) {
        iter = it;
        if (iter == 0)
            return arr;
        if (arr == null)
            return null;

        size = arr.length;
        double max = arr[0];
        double min = arr[0];
        for (double m: arr) {
            if (m>max) {
                max = m;
            }
            if (m<min) {
                min = m;
            }
        }

        if (max == min)
            return arr;
        if (Double.isNaN(min) || Double.isNaN(max))
            return null;

        this.MAX_VALUE = max;
        this.MIN_VALUE = min;

        this.collection = new Vector<>(size);
        for (int i=0; i<size; i++) {
            this.collection.add(new Vector<>());
        }

        for (int i=0; i< size; i++) {
            int ind = index(arr[i]);

            if (this.collection.get(ind).size() == 0 || this.collection.get(ind).get(0) == arr[i]) {
                this.collection.get(ind).add(0, arr[i]);
            }
            else {
                double[] vec_array = new double[collection.get(ind).size()+1];
                for (int j=0; j<collection.get(ind).size(); j++) {
                    vec_array[j] = collection.get(ind).get(j);
                }
                vec_array[vec_array.length-1] = arr[i];
                HashTable<Number> new_collection = new HashTable<>();
                double[] new_vector = new_collection.sort(vec_array, true, iter);
                if (iter == 0) {
                    return new_vector;
                }
                collection.get(ind).clear();
                for (int k=0; k<new_vector.length; k++) {
                    collection.get(ind).add(k, new_vector[k]);
                }
            }
        }

        if (iter > 0)
            iter -= 1;

        double[] res = new double[arr.length];
        int i = 0;

        for (int k=0; i<this.collection.size(); k++) {
            for (int j=0; j<this.collection.get(k).size(); j++) {
                res[i++] = this.collection.get(k).get(j);
            }
            if (i==res.length) {
                break;
            }
        }

//        System.out.println(this.collection);
//        System.out.println(Arrays.toString(res));
        return res;
    }

    private int index(double val) {
        if (val == MAX_VALUE) {
            return size-1;
        }
        return (int)Math.floor((val-MIN_VALUE)*size/(MAX_VALUE-MIN_VALUE));
    }

}
