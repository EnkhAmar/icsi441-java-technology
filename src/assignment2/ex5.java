package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
/*
10 цифрээс бүтдэг тэмдэг мөр S,  болон текст файл өгөгдөв.
Энэ файлыг дараах байдлаар шифрлэ: тэмдэгт мөрийн үсэг бүрийг
түүний цагаан толгойн байрлалаас хойш K-дахь байрлалд буй үсгээр
нь солино. Хэрэв цагаан толгойн төгсгөлд хүрсэн үед цагаан толгойн
эхнээс  үргэлжлүүлэн  тоолно. Цэг,  таслал,  хоосон  зайн  гэх  үсэг
биш тэмдэгтүүдийг авч үзэхгүй. (жишээлбэл, K=11 үед «а» үсэг «й» үсгээр
солигдоно, гэх мэт).
 */
public class ex5 {
    File file;
    public ex5(String filePath, int k) throws FileNotFoundException {
        file = new File(filePath);
        Scanner scanner = new Scanner(file);
        File tmpFile = new File("test/resources/tmp");
        PrintWriter output = new PrintWriter(tmpFile);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            output.println(encrypt(s, k));
        }
        output.close();
        tmpFile.renameTo(file);
    }

    public String encrypt(String s, int shift) {
        StringBuilder encryptedLine = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                int position = c - 'A';
                int encryptedPosition = (position + shift) % 26;
                char encryptedChar = (char) (encryptedPosition + 'A');
                encryptedLine.append(encryptedChar);
            } else  {
                encryptedLine.append(c);
            }
        }
        return encryptedLine.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "test/resources/assignment2-ex5.txt";
        int k = 11;
        new ex5(filePath, k);
    }
}
