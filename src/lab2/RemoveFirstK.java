package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

// @student: G.Enkh-Amar /18b1um0399/
// К гэсэн бүхэл тоо болон текст файл өгөгджээ. Энэ файлын мөр бүрийн эхний К тэмдэгтийг нь
// устга. (Хэрвээ мөрийн урт К-аас бага байвал бүх тэмдэгтүүдийг нь устга.)
public class RemoveFirstK {
    int k;
    File file;
    String trimmed;
    public RemoveFirstK(int k) throws FileNotFoundException {
        this.k = k;
        file = new File("test/resources/abc.txt");
        Scanner scanner = new Scanner(file);
        File tmpFile = new File("test/resources/tmp");
        PrintWriter output = new PrintWriter(tmpFile);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.length() >= k) {
                trimmed = s.substring(k);
            } else {
                trimmed = "";
            }
            output.println(trimmed);
        }
        output.close();
        tmpFile.renameTo(file);
    }
    public static void main(String[] args) throws FileNotFoundException {
        new RemoveFirstK(5);
    }
}
