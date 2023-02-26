package assignment2;

// @student: G.Enkh-Amar /18b1num0399/
/* Текст файл өгөгдөв. Файлын бүх жижиг
үсгийг томоор, том үсгийг жижгээр соль.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ex1 {
    File file;
    public ex1() throws FileNotFoundException {
        file = new File("test/resources/assignment2-ex1.txt");
        Scanner scanner = new Scanner(file);
        File tmpFile = new File("test/resources/tmp");
        PrintWriter output = new PrintWriter(tmpFile);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            output.println(swapCase(s));
        }
        output.close();
        tmpFile.renameTo(file);
    }

    public String swapCase(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new ex1();
    }
}
