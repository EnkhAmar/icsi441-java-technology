package assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// @student: G.Enkh-Amar /18b1num0399/
// B1. Тэмдэгт  мөр  өгөгдөв.  Түүний  сүүлийн  тэмдэгттэй ижил  байх тэмдэгтүүдийн байрлалын дугаарыг хэвлэ.
public class B1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter: ");
        String string = in.next();
        Character lastChar = string.charAt(string.length()-1);
        int captured[] = getMatchingIndexArray(lastChar.toString(), string);
        System.out.println("index: " + Arrays.toString(captured));
    }

    public static int[] getMatchingIndexArray(String regex, String _string) {
        List<Integer> indexList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(_string);
        while (matcher.find()) {
            indexList.add(matcher.start());
//            System.out.println("Start index: " + matcher.start());
//            System.out.println("End index: " + matcher.end());
//            System.out.println("Found: " + matcher.group());
        }
        int[] indexes = indexList.stream().mapToInt(i -> i).toArray();
        return indexes;
    }
}
