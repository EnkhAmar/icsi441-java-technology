package assignment6;

import java.util.ArrayList;

// @student: G.Enkh-Amar /18b1num0399/
/*
Өгөгдсөн завсарт байдаг хамгийн олон хуваагчтай бүхэл тоог ол.
Хэдэн хэдэн хуваагчтай бэ? Үр дүнг хэвлэ. Өгөгдсөн завсарт хэд
хэдэн ийм бүхэл тоо байж болно.
 */
public class Exercise1 {
    private static final int THREAD_COUNT = 4;
    private static final int INTERVAL_START = 1;
    private static final int INTERVAL_END = 10000;

    public static void main(String[] args) throws InterruptedException {
        int intervalSize = INTERVAL_END - INTERVAL_START + 1;
        int chunkSize = intervalSize / THREAD_COUNT;

        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<DivisorWorker> workers = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = INTERVAL_START + i * chunkSize;
            int end = (i == THREAD_COUNT - 1) ? INTERVAL_END : start + chunkSize - 1;
            DivisorWorker worker = new DivisorWorker(start, end);
            workers.add(worker);
            Thread thread = new Thread(worker);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int maxDivisors = 0;
        int maxDivisorsNumber = 0;

        for (DivisorWorker worker : workers) {
            if (worker.getMaxDivisors() > maxDivisors) {
                maxDivisors = worker.getMaxDivisors();
                maxDivisorsNumber = worker.getMaxDivisorsNumber();
            }
        }

        System.out.println("Number with the most divisors: " + maxDivisorsNumber);
        System.out.println("Number of divisors: " + maxDivisors);
    }

    private static class DivisorWorker implements Runnable {
        private final int start;
        private final int end;
        private int maxDivisors = 0;
        private int maxDivisorsNumber = 0;

        public DivisorWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                int divisorCount = countDivisors(i);
                if (divisorCount > maxDivisors) {
                    maxDivisors = divisorCount;
                    maxDivisorsNumber = i;
                }
            }
        }

        public int getMaxDivisors() {
            return maxDivisors;
        }

        public int getMaxDivisorsNumber() {
            return maxDivisorsNumber;
        }

        private int countDivisors(int n) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    count++;
                }
            }
            return count;
        }
    }
}

