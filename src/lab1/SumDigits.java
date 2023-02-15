package lab1;
import java.util.Scanner;

// @student: G.Enkh-Amar /18b1bnum0399/
// Exercise 6.2. sumDigits

public class SumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER NUMBER: ");
        long input = sc.nextLong();
        System.out.println("SUM OF DIGITS: " + sumDigits(input));
    }

    public static int sumDigits(long n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}