package assignment1;

import java.util.Arrays;
import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
/*
B6. x1−x2+x3−x4+..., хэлбэртэй текст өгөгдөв, үүнд xi – бол
цифр эсвэл хоёр оронтой тоо. Энэ илэрхийллийн утгыг ол.
 */
public class B6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine().trim();
        int result = evaluateExpression(expr);
        System.out.println("Result: " + result);
    }

    public static int evaluateExpression(String expr) {
        String[] terms = expr.split("\\s*[-+]\\s*");
        String[] operators = expr.split("\\s*\\d+\\s*");
        int result = Integer.parseInt(terms[0]);
        for (int i = 1; i < terms.length; i++) {
            int num = Integer.parseInt(terms[i]);
            if (operators[i].charAt(0) == '-') {
                result -= num;
            } else {
                result += num;
            }
        }
        return result;
    }
}
