package lab1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// @student: G.Enkh-Amar /18b1bnum0399/
// Өгөдсөн текстээс зөвхөн цагаан толгойн үсэг орсон үгнүүдийн тоо, том, жижиг
// үсэгнүүдийг тоолох програм бич.

public class LetterCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = in.nextLine();

        int uppercase = 0;
        int lowercase = 0;
        int words = 0;

        for (int i=0; i<text.length(); i++) {
            Character x = text.charAt(i);
            if (Character.isLetter(x)) {
                if (Character.isUpperCase(x)){ uppercase++; }
                else lowercase++;
            }
        }

        String wordArray[] = text.split(" ");
        for (String word: wordArray) {
            if (checkRegex("^([a-zA-Z]+)$", word)) {
                words++;
            }
        }

        System.out.println("Uppercase: " + uppercase);
        System.out.println("Lowercase: " + lowercase);
        System.out.println("Word: " + words);
    }
    public static boolean checkRegex(String regex, String text) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}