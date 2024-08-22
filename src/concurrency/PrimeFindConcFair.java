package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeFindConcFair {
    private static final int MAX_INT = 100000000;
    private static final int CONCURRENCY = 10;
    private static AtomicInteger totalPrimeNumbers = new AtomicInteger(0);
    private static AtomicInteger currentNum = new AtomicInteger(2);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(CONCURRENCY);

        for (int i = 0; i < CONCURRENCY; i++) {
            final int threadNum = i;
            executor.execute(() -> doWork("Thread-" + threadNum));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Checking till " + MAX_INT + ", found " + (totalPrimeNumbers.get() + 1)
                + " prime numbers. Took " + (System.currentTimeMillis() - start) + " ms.");
    }

    private static void doWork(String name) {
        long start = System.currentTimeMillis();

        while (true) {
            int x = currentNum.incrementAndGet();
            if (x > MAX_INT) {
                break;
            }
            checkPrime(x);
        }

        System.out.println(name + " completed in " + (System.currentTimeMillis() - start) + " ms.");
    }

    private static void checkPrime(int x) {
        if ((x & 1) == 0) {
            return;
        }
        int sqrt = (int) Math.sqrt(x);
        for (int i = 3; i <= sqrt; i += 2) {
            if (x % i == 0) {
                return;
            }
        }
        totalPrimeNumbers.incrementAndGet();
    }
}
