package lab9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// @student: G.Enkh-Amar /18b1num0399/
/* 32.4.
(Synchronize threads) Write a program that launches 1,000 threads. Each thread
adds 1 to a variable sum that initially is 0. You need to pass sum by reference to
each thread. In order to pass it by reference, define an Integer wrapper object to
hold sum. Run the program with and without synchronization to see its effect.
 */
public class SynchronizeThreads {
    ExecutorService executor = Executors.newFixedThreadPool(1000);
    SumminTask task = new SumminTask();

    public SynchronizeThreads() {
        for (int i = 0; i < 1000; i++) {
            executor.execute(task);
        }
        executor.shutdown();
        System.out.println(task);
    }

    public static void main(String[] args) {
        new SynchronizeThreads();
    }
}
