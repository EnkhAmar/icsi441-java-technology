package assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
// B2. Текст  өгөгдөв. Хамгийн  олон  дараалсан цифрүүдийн  тоог  ол.Эдгээр цифрүүдийн нийлбэр ол.

public class B2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        String text = in.nextLine();
        int[] _digits = getDigits(text);
        System.out.println(Arrays.toString(_digits));
        System.out.println(calculateMaxConsecutive(_digits));
    }

    public static int[] getDigits(String _text) {
        List<Integer> digitList = new ArrayList<>();
        for (int i = 0; i < _text.length(); i++) {
            if (Character.isDigit(_text.charAt(i)))
                digitList.add(Character.getNumericValue(_text.charAt(i)));
        }
        int[] digits = digitList.stream().mapToInt(i -> i).toArray();
        return digits;
//        System.out.println(Arrays.toString(digits));
    }

    public static int calculateMaxConsecutive(int[] digits) {
        int maxConsecutive = 0;
        int currentConsecutive = 0;
        int startIndex = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i == 0 || digits[i] == digits[i-1]) {
                currentConsecutive++;
            } else {
                if (currentConsecutive > maxConsecutive) {
                    maxConsecutive = currentConsecutive;
                    startIndex = i - currentConsecutive;
                }
                currentConsecutive = 1;
            }
        }
        if (currentConsecutive > maxConsecutive) {
            maxConsecutive = currentConsecutive;
            startIndex = digits.length - currentConsecutive;
        }
        return maxConsecutive;
    }
}
