package assignment9;

// @student: G.Enkh-Amar
/*
Натураль тоо n өгөгдөв. n-ээс бага бөгөөд харилцан анхны бүх натураль тоог ол.
Тайлбар:±1-ээс өөр ерөнхий хуваагчгүй бүхэл тоонуудыг харилцан анхны гэнэ.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise4 {
    public static void main(String[] args) {
        int n = 50;

        List<Integer> primes = findPrimes(n);

        System.out.println("Prime numbers less than or equal to " + n + ":");
        primes.forEach(System.out::println);
    }

    private static List<Integer> findPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(Exercise4::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
