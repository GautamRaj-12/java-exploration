package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeFindConcUnfair {

    static final int MAX_INT = 100000000;
    static final int CONCURRENCY = 10;
    static AtomicInteger totalPrimeNumbers = new AtomicInteger(0);

    public static void checkPrime(int x) {
        if (x % 2 == 0) {
            return;
        }
        for (int i = 3; i <= Math.sqrt(x); i += 2) {
            if (x % i == 0) {
                return;
            }
        }
        totalPrimeNumbers.incrementAndGet();
    }

    public static void doBatch(String name, int nstart, int nend) {
        long start = System.currentTimeMillis();
        for (int i = nstart; i < nend; i++) {
            checkPrime(i);
        }
        System.out.printf("Thread %s [%d, %d) completed in %d ms\n", name, nstart, nend, System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(CONCURRENCY);
        int nstart = 3;
        int batchSize = MAX_INT / CONCURRENCY;

        for (int i = 0; i < CONCURRENCY - 1; i++) {
            final int batchStart = nstart; // Make variable effectively final
            final int batchEnd = nstart + batchSize; // Make variable effectively final
            executor.submit(() -> doBatch(Integer.toString(batchStart), batchStart, batchEnd));
            nstart += batchSize;
        }
        final int batchStart = nstart; // Make variable effectively final
        executor.submit(() -> doBatch(Integer.toString(batchStart), batchStart, MAX_INT));

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Checking till " + MAX_INT + ", found " + (totalPrimeNumbers.get() + 1) +
                " prime numbers. Took " + (System.currentTimeMillis() - start) + " ms");
    }
}
