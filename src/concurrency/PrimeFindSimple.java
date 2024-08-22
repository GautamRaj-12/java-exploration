package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class PrimeFindSimple {

    static final int MAX_INT = 100000000;
    static AtomicInteger totalPrimeNumbers = new AtomicInteger(0);

    public static void checkPrime(int x) {
        if (x % 2 == 0) {
            return;
        }
        for (int i = 3; i <= Math.sqrt(x); i ++) {
            if (x % i == 0) {
                return;
            }
        }
        totalPrimeNumbers.incrementAndGet();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 3; i < MAX_INT; i++) {
            checkPrime(i);
        }
        System.out.println("Checking till " + MAX_INT + ", found " + (totalPrimeNumbers.get() + 1) +
                " prime numbers. Took " + (System.currentTimeMillis() - start) + " ms");
    }
}
