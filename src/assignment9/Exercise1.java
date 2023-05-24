package assignment9;

import java.util.Scanner;

// @student: G.Enkh-Amar
/*
А(x,  y) цэгийн  координатуудыг гараас  оруулав.
у=2-х2 парабол ба y=-2 шулуунаар хязгаарлагдсан
мужид А цэг оршдог эсэхийг тодорхойл. Хариуг
оршдог эсвэл оршдоггүй гэж хариулна.
 */

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        double x = scanner.nextDouble();
        System.out.print("Enter y: ");
        double y = scanner.nextDouble();

        boolean isInRegion = isPointInRegion(x, y);

        // Print the result
        String result = isInRegion ? "оршдог" : "оршдоггүй";
        System.out.println(result);

        scanner.close();
    }

    public static boolean isPointInRegion(double x, double y) {
        return (y >= -2) && (y <= 2 - Math.pow(x, 2));
    }
}
