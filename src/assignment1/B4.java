package assignment1;

import java.util.Arrays;
import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
/*
B4. Тэмдэгт мөр өгөгдөв. Хэрэв түүний тэмдэгтүүд цагаан толгойн
үсгийн дарааллаар эрэмбэлэгдсэн бол 'yes', эсрэг тохиолдолд
цагаан толгойн дараалал үүсгэхгүй эхний тэмдэгтийг хэвлэ.
 */
public class B4 {
    public static void main(String[] args) {
        System.out.println("Enter string: ");
        Scanner scanner =  new Scanner(System.in);
        String string = scanner.next();
        String result = isSorted(string);
        System.out.println("Result: " + result);
    }

    public static String isSorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sortedString = new String(chars);
        if (s.equals(sortedString)) {
            return "yes";
        } else {
            return Character.toString(chars[0]);
        }
    }
}
