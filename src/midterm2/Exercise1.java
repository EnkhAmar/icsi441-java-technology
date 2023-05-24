package midterm2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// @student: G.Enkh-Amar
/*
Бодлого No1.Үйлдвэрийнбүтээмж  эхний  жилдp p1 хувиар,  хоёр  ба  гуравдахь  жилд харгалзан p2 ба p3
хувиар тус тус өсөв. Үйлдвэрийн дундаж бүтээмжийг ол. Жил  бүрийн  бүтээмжийн өсөлт тогтмол p
байдаг  гэвэл p=p1=p2=p3 байна. Ерөнхий тохиолдолд, нийт 3 жилийн ерөнхий өсөлт
Ерөнхий тохиолдолд, n жилийн дараах хөдөлмөрийн  бүтээмжийг ол.
 */
public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Оруулах n утгын тоог оруул: ");
            int n = scanner.nextInt();

            double[] productivityValues = new double[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Бүтээмж " + (i + 1) + ": ");
                productivityValues[i] = scanner.nextDouble();
            }
            double averageProductivity = (Arrays.stream(productivityValues)
                    .reduce(1, (a, b) -> a * (1 + b / 100)) - 1) * 100;

            System.out.println("" + n + " жилийн хугацаанд " + averageProductivity + " хувиар өссөн байна.");
        } catch (InputMismatchException e) {
            System.out.println("Тоон зөв утга оруулна уу.");
        } finally {
            scanner.close();
        }
    }
}
