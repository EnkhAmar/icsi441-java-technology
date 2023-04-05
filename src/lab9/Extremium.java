package lab9;

// @student: G.Enkh-Amar /18b1num0399/
/*
Гарнаас нэг массивын утгуудыг оруулна.
1 thread-ээр массиваас max утгыг, нөгөө thread-ээр  массиваас min утгыг олно.
 */

public class Extremium {
    int[] arr = {1,4,63,6,23};
    Thread thread1, thread2;
    Max taskMax;
    Min taskMin;

    public Extremium() throws InterruptedException {
        taskMax = new Max(arr);
        taskMin = new Min(arr);

        thread1 = new Thread(taskMax, "Max thread");
        thread2 = new Thread(taskMin, "Min thread");

        thread1.setPriority(1);
        thread2.setPriority(8);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(taskMax);
        System.out.println(taskMin);
    }

    public static void main(String[] args) {
        try {
            new Extremium();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
