package assignment4;

// @student: G.Enkh-Amar /18b1num0399/
/*
3х3 хэмжээтэй бодит тоон матрицууд хадгалдаг бинар файл өгөгдөв. Эдгээр матрицийн гол диагоналийн
доор байрлах тэгээс ялгаатай бүх элементийг X тоогоор соль. Ингэж хувиргасан матрицуудыг шинэ
файл руу бич.
 */

import java.io.*;
import java.util.Random;

public class ex2 {
    int[][] matrices = new int[3][3];
    String input = "test/resources/assignment4-ex2-input.bin";
    String output = "test/resources/assignment4-ex2-output.bin";

    public ex2() throws IOException, ClassNotFoundException {
        int x = 99;
        createFile();
        System.out.println("INPUTS:");
        printMatrices();

        writeFile(x);
        System.out.println("OUTPUT:");
        printMatrices();
    }

    void createFile() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(input));
        fillMatrices();
        objectOutputStream.writeObject(matrices);
        objectOutputStream.close();
    }

    void fillMatrices () {
        for (int i = 0; i < matrices.length; i++) {
            for (int j = 0; j < matrices[0].length; j++) {
                matrices[i][j] = generateRandomNumber(-5, 5);
            }
        }
    }

    void printMatrices() {
        for (int i = 0; i < matrices.length; i++) {
            for (int j = 0; j < matrices[0].length; j++) {
                System.out.print(matrices[i][j] + " ");
            }
            System.out.println();
        }
    }

    int[][] replaceWithX(int[][] target, int x) {
        int rows = target.length;
        int cols = target[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > j && target[i][j] != 0) {
//                    System.out.println("[" + i + "][" + j +"]"+"=" + target[i][j]);
                    target[i][j] = x;
                }
            }
        }
        return target;
    }

    void writeFile(int x) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(input));
        int[][] inputObject = (int[][]) objectInputStream.readObject();
        matrices = replaceWithX(inputObject, x);
        objectInputStream.close();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(output));
        objectOutputStream.writeObject(matrices);
        objectOutputStream.close();
    }

    int generateRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    public static void main(String[] args) {
        try {
            new ex2();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }
}
