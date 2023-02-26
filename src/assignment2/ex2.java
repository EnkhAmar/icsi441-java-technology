package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
/*
Бүхэл тоо K ба текст файл өгөгдөв. Файлын K дахь
мөрийн дараа хоосон мөр нэм. Хэрэв ийм K дахь мөр
байдаггүй бол файлд ямар нэг өөрчлөлт хийхгүй.
 */
public class ex2 {
    File file;
    public ex2(String filePath, int k) throws FileNotFoundException {
        file = new File(filePath);
        Scanner scanner = new Scanner(file);
        File tmpFile = new File("test/resources/tmp");
        PrintWriter output = new PrintWriter(tmpFile);
        int counter = 0;
        while (scanner.hasNext()) {
            counter++;
            String s = scanner.nextLine();
            output.println(s);
            if (counter == k) {
                output.println();
            }
        }
        output.close();
        tmpFile.renameTo(file);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "test/resources/assignment2-ex2.txt";
        int k = 5;
        new ex2(filePath, k);
    }
}
