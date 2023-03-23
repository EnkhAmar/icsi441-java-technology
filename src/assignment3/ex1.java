package assignment3;

// @student: G.Enkh-Amar
/*
Бүхэл тоон утгууд агуулдаг бинар файл өгөгдөв. Бүх бүхэл тооны арифметик дундажаас
бага байх бүх тоог энэ файлаас устга.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class ex1 {
    String file = "test/resources/assignment3-ex1.bin";
    DataOutputStream dout;
    DataInputStream din;

    public ex1(int num) throws IOException {
        createFile(num);
        removeBelowAverage();
    }

    void createFile(int num) throws IOException {
        dout = new DataOutputStream(new FileOutputStream(file));
        ArrayList<Integer> randNums = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            int r = generateRandomInt(-10, 9);
            randNums.add(r);
            dout.writeInt(r);
        }
        dout.close();
        System.out.println(randNums);
        System.out.println("DONE CREATING");
    }

    double calculateAverage(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int currentNumber = arrayList.get(i);
            sum += currentNumber;
        }
        return sum / arrayList.size();
    }

    void removeBelowAverage() throws IOException {
        din = new DataInputStream(new FileInputStream(file));
        int current;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (din.available() != 0) {
            current = din.readInt();
            numbers.add(current);
        }
        din.close();

        double avg = calculateAverage(numbers);
        System.out.println("AVG = " + avg);

        dout = new DataOutputStream(new FileOutputStream(file));
        for (int i = 0; i < numbers.size(); i++) {
            if (avg < numbers.get(i)) {
                dout.writeInt(numbers.get(i));
                System.out.println(numbers.get(i));
            }
        }
        dout.close();
        System.out.println("DONE REMOVING");
    }

    int generateRandomInt(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    public static void main(String[] args) {
        try {
            new ex1(10);
        } catch (IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }
}
