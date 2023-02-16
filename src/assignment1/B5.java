package assignment1;

import java.util.Scanner;
import java.util.Stack;

// @student: G.Enkh-Amar /18b1num0399/
/*
B5. Үсгүүд ба '(', ')', '[', ']', '{', '}' хаалтууд агуулдаг тэмдэгт
мөр өгөгдөв. Хэрэв хаалтууд зөв байрладаг (ө.х, нээх хаалт болгонд хаах
зөв хаалт нь харгалздаг байвал 'yes', хэрэв хаах хаалт байдаггүй бол -1 хэвлэ)
 */
public class B5 {
    public static void main(String[] args) {
        System.out.println("Enter: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (isBalanced(string)) {
            System.out.println("yes");
        } else {
            System.out.println("-1");
        }
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
