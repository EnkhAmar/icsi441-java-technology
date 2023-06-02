package final_exam;

import java.util.Scanner;

// @student: G.Enkh-Amar
/*
Гараас x, y, m, n гэсэн 4 тоог оруулна. x тооны бага m битийг y тооны
ахлах n битээр сольж, дараа нь y тооны бага n битийг инверт хийнэ. Шилжлэгийн
бүх бит хамгийн бага (тэг) битээс эхлэнэ. Програмд оролтын өгөгдлүүдийг аравтын
тооллын системд оруулна, харин үр дүн болох x, y утгуудыг хоёртын тооллын системд хэвлэнэ.
 */

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        System.out.print("Enter m: ");
        int m = scanner.nextInt();
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        int[] result = replaceAndInvertBits(x, y, m, n);

        System.out.println("Result x: " + result[0]);
        System.out.println("Result y: " + result[1]);
    }

    public static int[] replaceAndInvertBits(int x, int y, int m, int n) {
        String xBinary = Integer.toBinaryString(x);
        String yBinary = Integer.toBinaryString(y);

        xBinary = String.format("%" + Math.max(m, xBinary.length()) + "s", xBinary).replace(' ', '0');
        yBinary = String.format("%" + Math.max(n, yBinary.length()) + "s", yBinary).replace(' ', '0');

        // x тооны бага m битийг y тооны ахлах n битээр солино
        String replacedX = xBinary.substring(0, xBinary.length() - m) + yBinary.substring(0, n);

        // y-ын бага n битийг инверт хийнэ
        String invertedY = yBinary.substring(0, yBinary.length() - n);
        for (int i = yBinary.length() - n; i < yBinary.length(); i++) {
            invertedY += (yBinary.charAt(i) == '0') ? '1' : '0';
        }

        // 10 тооллын тооруу хөрвүүлнэ
        int resultX = Integer.parseInt(replacedX, 2);
        int resultY = Integer.parseInt(invertedY, 2);

        return new int[]{resultX, resultY};
    }
}

