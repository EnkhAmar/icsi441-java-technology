package assignment1;

import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
/*
B3. Тэмдэгт мөр өгөгдөв. Хэрэв энэ  мөр 'abc'-ээр эхэлдэг
бол түүнийг 'www'-ээр солино, эсрэг тохиолдолд мөрийн
төгсгөлд 'zzz'-г нэм.
 */
public class B3 {
    final static String lookUpStr = "abc";
    final static String beginingReplace = "www";
    final static String endingAppend = "zzz";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String result = "";
        if (string.startsWith(lookUpStr))  result = string.replaceFirst(lookUpStr, beginingReplace);
        if (string.endsWith(lookUpStr)) result += endingAppend;
        System.out.println("Result: " + result);
    }
}
