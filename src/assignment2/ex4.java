package assignment2;

// @student: G.Enkh-Amar /18b1num0399/
/*
A, B бодит тоонууд, N бүхэл тоо өгөгдөв. [A, B] хэрчмийн  (B–A)/N алхамтай цэгүүд дээрх
sin(x) ба cos(x) функцуудын утгуудаар үүсэх хүснэгтийг агуулдаг текст файл үүсгэ. Хүснэгт
3  баганатай:  хүснэгтийн  эхний  багананд x хувьсагчийн  утгууд (8оронтой тоо байх ба
бутархайн хэсэг 4 оронтой) , хоёрдахь ба гуравдахь багануудад sin(x) ба cos(x) функцуудын
утгууд (12 оронтой тоо байх ба бутархайн хэсэг 8 оронтой) байна. Багана бүр дэх утгууд баруун
талаасаа зэрэгцсэн байна.
 */

import java.io.FileWriter;
import java.io.IOException;

public class ex4 {
    public ex4(String filePath) throws IOException {
        double A = 0;
        double B = Math.PI * 2;
        int N = 100;
        double step = (B - A) / N;

        FileWriter writer = new FileWriter(filePath);
        writer.write(String.format("%-20s%-20s%-20s\n", "x", "sin(x)", "cos(x)"));

        for (double x = A; x <= B; x += step) {
            double sinVal = Math.sin(x);
            double cosVal = Math.cos(x);
            writer.write(String.format("%20.4f%20.8f%20.8f\n", x, sinVal, cosVal));
        }
        writer.close();
        System.out.println("Trig table generated successfully!");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "test/resources/assignment2-ex4.txt";
        new ex4(filePath);
    }
}
