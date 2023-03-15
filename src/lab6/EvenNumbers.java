package lab6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class EvenNumbers {
    int num;
    String file = "test/resources/data.out";
    FileOutputStream fout;
    FileInputStream fin;

    public EvenNumbers() throws IOException {
        this(1);
    }

    public EvenNumbers(int num) throws IOException {
        this.num = num;
        try {
            fwrite();
            fread();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void fwrite() throws IOException {
        fout = new FileOutputStream(file);
        Random rnd = new Random();
        int r;
        for (int i = 0; i < num; i++) {
            r = rnd.nextInt(100);
            System.out.println(r);
            fout.write(r);
        }
        fout.close();
    }

    boolean isEven(int num) {
        return num % 2 == 0;
    }

    void fread() throws IOException {
        fin = new FileInputStream(file);
        int total = 0;
        int even = 0;
        while (fin.available() != 0) {
            total++;
            if (isEven(Integer.valueOf(fin.read()))) even++;
        }
        fin.close();
        System.out.println("Result: " + (double)even/(double)total);
    }

    public static void main(String[] args) {
        try {
            new EvenNumbers(10);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}