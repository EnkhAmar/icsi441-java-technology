package lab1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// @student: G.Enkh-Amar /18b1bnum0399/
// Exercise 4.21. (Check SSN)
public class CheckSSN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a SSN: ");
        String ssn = in.next();
        boolean isCorrect = checkRegex("^\\d{3}-\\d{2}-\\d{4}$", ssn);
        if (isCorrect) {
            System.out.println(ssn + " is a valid social security number");
        } else {
            System.out.println(ssn + " is an invalid social security number");
        }
    }

    public static boolean checkRegex(String regex, String text) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}