package lab6;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

// @student: G.Enkh-Amar
/*
Санамсаргүй өгөдсөн бүхэл тоонуудаас хамгийн эхний сөрөг болон хамгийн сүүлийн сөрөг тоонууд хоорондох бүх сөрөг
тоонуудыг устга.
 */
public class NegativeNumberRemover {
    String file = "test/resources/negative-remover.out";
    DataOutputStream dout;
    DataInputStream din;
    int num;
    public NegativeNumberRemover(int num) throws IOException {
        this.num = num;
        createFile(num);
        removeNegative();
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

    void removeNegative() throws IOException {
        din = new DataInputStream(new FileInputStream(file));
        int current;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (din.available() != 0) {
            current = din.readInt();
            numbers.add(current);
        }
        din.close();

        boolean firstNegativeFound = false;
        int firstNegativeIndex = 0;
        int lastNegativeIndex = 0;

        // Find the first and last negative numbers
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber < 0) {
                if (!firstNegativeFound) {
                    firstNegativeFound = true;
                    firstNegativeIndex = i;
                }
                lastNegativeIndex = i;
            }
        }

        // Remove negative numbers between the first and last negatives, excluding the first and last negatives
        for (int i = firstNegativeIndex + 1; i < lastNegativeIndex; i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber < 0) {
                numbers.remove(i);
                i--; // Move the index back to account for the removed element
                lastNegativeIndex--; // Update the index of the last negative number
            }
        }
        System.out.println(numbers);
        System.out.println("DONE REMOVING");
        reWriteFile(numbers);
    }

    void reWriteFile(ArrayList<Integer> numbers) throws IOException {
        dout = new DataOutputStream(new FileOutputStream(file));
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            dout.writeInt(currentNumber);
        }
        dout.close();
    }

    int generateRandomInt(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return  randomNumber;
    }

    public static void main(String[] args) {
        try {
            new NegativeNumberRemover(10);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
