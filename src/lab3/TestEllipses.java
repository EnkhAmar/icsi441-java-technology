package lab3;

import java.util.Scanner;

public class TestEllipses {
    double rad1, rad2;
    String color;
    Boolean isFilled;
    Ellipses ellipses;
    public TestEllipses() {
        input();
        System.out.println(ellipses);
    }

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Эллипсийн радиус утгуудыг оруул: ");
        rad1 = scanner.nextDouble();
        rad2 = scanner.nextDouble();

        System.out.println("Эллипсийн өнгө оруул: ");
        color = scanner.next();

        System.out.println("Эллипсийн будагдсан эсэх: ");
        isFilled = scanner.nextBoolean();

        ellipses = new Ellipses(color, isFilled, rad1, rad2);
    }

    public static void main(String[] args) {
        new TestEllipses();
    }
}
