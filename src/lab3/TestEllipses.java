package lab3;

import java.util.Scanner;

public class TestEllipses {
    double rad1, rad2;
    String color;
    Boolean isFilled;
    Ellipses ellipses;
    public TestEllipses() {
//        input();
//        System.out.println(ellipses.toString());
        GeometricObject[] geo = new GeometricObject[5];

        for (int i = 0; i < geo.length; i++) {
            geo[i] = createEllipses();
            if(geo[i] instanceof Colorable) {
                ((Colorable) geo[i]).howToColor();
            }
            System.out.println("----------------------");
        }

        for (GeometricObject geoObj : geo) {
            System.out.println(geoObj);
        }
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

    Ellipses createEllipses() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Эллипсийн радиус утгуудыг оруул: ");
        rad1 = scanner.nextDouble();
        rad2 = scanner.nextDouble();

        System.out.println("Эллипсийн өнгө оруул: ");
        color = scanner.next();

        System.out.println("Эллипсийн будагдсан эсэх: ");
        isFilled = scanner.nextBoolean();

//        Ellipses newEllipses = new Ellipses(color, isFilled, rad1, rad2);
        ellipses = new Ellipses(color, isFilled, rad1, rad2);
        return ellipses;
    }

    public static void main(String[] args) {
        new TestEllipses();
    }
}
