package lab9;

public class Min implements Runnable{
    int[] arr;
    int min = Integer.MAX_VALUE;

    public Min(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
    }

    public int getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "Min= " + min;
    }
}
