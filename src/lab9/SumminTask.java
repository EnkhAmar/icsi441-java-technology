package lab9;

public class SumminTask implements Runnable {
    Integer sum = 0;

    public SumminTask() {
    }

    @Override
    public void run() {
        synchronized (sum) {
            sum++;
        }
    }

    public Integer getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "sum=" + sum;
    }
}
