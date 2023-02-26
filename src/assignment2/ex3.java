package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
/*
Зүүн захаас зэрэгцсэн текст агуулдаг текст файл өгөгдөв.
Хоосон биш мөрийн эхэнд шаардлагатай тооны хоосон зай нэмэх
замаар мөрийг баруун захаасаа зэрэгцсэн болго. (текст нь 50
тэмдэгтийн өргөнтэй гэж үз).
 */
public class ex3 {
    File file;
    static final int LINE_WIDTH = 50;
    public ex3(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        Scanner scanner = new Scanner(file);
        File tmpFile = new File("test/resources/tmp");
        PrintWriter output = new PrintWriter(tmpFile);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            for (int i = s.length(); i < LINE_WIDTH; i++) {
                output.print(" ");
            }
            output.println(s);
        }
        output.close();
        tmpFile.renameTo(file);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "test/resources/assignment2-ex3.txt";
        new ex3(filePath);
    }
}
