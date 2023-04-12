package lab10;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DonationAccount {
    double balance = 0;
    private Semaphore semaphore;

    public DonationAccount() {
        semaphore = new Semaphore(1);
        // Create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit runnable tasks to the executor
        executor.execute(new MyTask());
        executor.execute(new MyTask());

        // Shut down the executor
        executor.shutdown();

        System.out.println("balance=" + balance);
    }

    void deposit(double amount) throws InterruptedException {
        semaphore.acquire();
        balance += amount;
        semaphore.release();
    }

    class MyTask implements Runnable {
        Random random = new Random();
        @Override
        public void run() {
            try {
//                deposit(random.nextDouble(1000));
                deposit(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new DonationAccount();
    }
}
