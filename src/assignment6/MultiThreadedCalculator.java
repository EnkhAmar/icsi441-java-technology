package assignment6;

// @student: G.Enkh-Amar /18b1num0399/
/*
Оролтын текст файлуудыг дараах байдлаар нэрлэжээ:
in_<N>.dat, үүнд N – натурал тоо
Файл бүр хоёр мөр агуулдаг. Эхний мөрөнд үйлдлийг илэрхийлсэн тоо, хоёрдахь мөрөнд хоосон зайгаар тусгаарласан бодит тоонууд
Дараах тоонууд хийх үйлдлүүдийг илэрхийлнэ:
1 -нэмэх
2 -үржих
3 –квадратуудын нийлбэр олох
Файл тус бүр дэх тоон утгууд дээр харгалзах үйлдлүүд гүйцэтгэж үр дүнг out.dat файлд бичдэг олон трэдэт програм зохио.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadedCalculator {

    private static final String INPUT_FILE_PREFIX = "src/assignment6/in_";
    private static final String OUTPUT_FILE = "src/assignment6/out.dat";

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i<4; i++) {
            String inputFile = INPUT_FILE_PREFIX + i + ".dat";
            String[] inputLines = readInputFile(inputFile);
            if (inputLines == null) {
                break;
            }
            int action = Integer.parseInt(inputLines[0]);
            double[] numbers = parseNumbers(inputLines[1]);
            Thread thread = null;
            switch (action) {
                case 1:
                    thread = new PlusThread(numbers);
                    break;
                case 2:
                    thread = new MultiplyThread(numbers);
                    break;
                case 3:
                    thread = new SumOfSquaresThread(numbers);
                    break;
                default:
                    System.err.println("Invalid action: " + action);
                    break;
            }
            if (thread != null) {
                threads.add(thread);
                thread.start();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (Thread thread : threads) {
                thread.join();
                if (thread instanceof ResultHolder) {
                    ResultHolder resultHolder = (ResultHolder) thread;
                    writer.write(resultHolder.getResult() + "\n");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String[] readInputFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            if (line1 == null || line2 == null) {
                return null;
            }
            return new String[]{line1, line2};
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static double[] parseNumbers(String line) {
        String[] tokens = line.split(" ");
        double[] numbers = new double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Double.parseDouble(tokens[i]);
        }
        return numbers;
    }

    private interface ResultHolder {
        double getResult();
    }

    private static abstract class CalculationThread extends Thread implements ResultHolder {
        protected final double[] numbers;
        protected double result;

        public CalculationThread(double[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public double getResult() {
            return result;
        }
    }

    private static class PlusThread extends CalculationThread {
        public PlusThread(double[] numbers) {
            super(numbers);
        }

        @Override
        public void run() {
            for (double number : numbers) {
                result += number;
            }
        }
    }

    private static class MultiplyThread extends CalculationThread {
        public MultiplyThread(double[] numbers) {
            super(numbers);
        }

        @Override
        public void run() {
            result = 1.0;
            for (double number : numbers) {
                result *= number;
            }
        }
    }

    private static class SumOfSquaresThread extends CalculationThread {
        public SumOfSquaresThread(double[] numbers) {
            super(numbers);
        }

        @Override
        public void run() {
            for (double number : numbers) {
                result += number * number;
            }
        }
    }
}