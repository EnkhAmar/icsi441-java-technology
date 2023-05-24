package midterm2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// @student: G.Enkh-Amar
/*
Бодлого No2. Файлын нэр ба бүхэл тоо n, 1 ≤ n ≤ 26 өгөгдөв. Өгөгдсөн нэртэй текст файл үүсгэж,
түүнд n урттай, n тэмдэгт мөрийг бич. k дугаартай (k = 1, ..., n) мөрөнд k тооны латин цагаан
толгойн том үсэг,мөрийн баруун талд “*”-оор дүүргэнэ. Жишээлбэл, n = 4 үед файл нь"A***", "AB**",
"ABC*", "ABCD" мөрүүдийг агуулна.
 */
public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        try {
            do {
                System.out.print("n тоон утга (1 ≤ n ≤ 26): ");
                n = scanner.nextInt();
            } while (n < 1 || n > 26);

            String fileName = "midterm2_ex2_output.txt";

            final int finalN = n;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                IntStream.rangeClosed(1, finalN)
                        .mapToObj(k -> createLine(k, finalN))
                        .forEach(line -> writeLine(writer, line));

                System.out.println("Файл амжилттай үүслээ.");
            } catch (IOException e) {
                System.out.println("Файл үүсгэхэд алдаа гарлаа.");
                e.printStackTrace();
            }
        } catch (InputMismatchException e) {
            System.out.println("Тоон зөв утга оруулна уу.");
        } finally {
            scanner.close();
        }
    }

    private static String createLine(int k, int n) {
        String alphabets = IntStream.range(0, k)
                .mapToObj(i -> String.valueOf((char) ('A' + i)))
                .collect(Collectors.joining());

        String asterisks = IntStream.range(0, n - k)
                .mapToObj(i -> "*")
                .collect(Collectors.joining());

        return alphabets + asterisks;
    }

    private static void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Файлруу бичихэд алдаа гарлаа.");
            e.printStackTrace();
        }
    }
}
