package lab9;

import java.util.Arrays;

public class Max implements Runnable {
    int[] arr;
    int max = Integer.MIN_VALUE;

    public Max(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
    }

    @Override
    public String toString() {
        return "Max= " + max;
    }
}
