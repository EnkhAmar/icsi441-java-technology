package assignment9;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// @student: G.Enkh-Amar
/*
Монгол улсын гол мөрний тухай мэдээлэл агуулдаг бинар файл өгөгдөв:
•Голын нэр;
•Голын урсах урт(км);
•Дундаж гүн(м).

-50 м-ээс бага гүнтэй бүх голын нийт урсах уртыг ол
-Хамгийн богино урттайг ол
-Хамгийн гүехэн голыг тус тус ол
 */
public class RiverInformation {
    public static void main(String[] args) {
        String filename = "src/assignment9/exercise6_info.obj";

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            River river1 = new River("River A", 100, 40);
            River river2 = new River("River B", 200, 30);
            River river3 = new River("River C", 150, 60);
            River river4 = new River("River D", 200, 10);
            River river5 = new River("River E", 500, 90);

            objectOutputStream.writeObject(river1);
            objectOutputStream.writeObject(river2);
            objectOutputStream.writeObject(river3);
            objectOutputStream.writeObject(river4);
            objectOutputStream.writeObject(river5);

            System.out.println("File src/assignment9/exercise6_info.obj created.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            List<River> rivers = readRivers(objectInputStream);
            double totalFlowLength = calculateTotalFlowLength(rivers);
            double shortestLength = findShortestLength(rivers);
            String shallowestRiver = findShallowestRiver(rivers);

            System.out.println("50 м-ээс бага гүнтэй бүх голын нийт урсах урт: " + totalFlowLength);
            System.out.println("Хамгийн богино урттай: " + shortestLength);
            System.out.println("Хамгийн гүехэн гол: " + shallowestRiver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<River> readRivers(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        List<River> rivers = new ArrayList<>();
        while (true) {
            try {
                River river = (River) objectInputStream.readObject();
                rivers.add(river);
            } catch (EOFException e) {
                break;
            }
        }
        return rivers;
    }

    private static double calculateTotalFlowLength(List<River> rivers) {
        return rivers.stream()
                .filter(river -> river.getDepth() < 50)
                .mapToDouble(River::getLength)
                .sum();
    }

    private static double findShortestLength(List<River> rivers) {
        return rivers.stream()
                .mapToDouble(River::getLength)
                .min()
                .orElse(Double.NaN);
    }

    private static String findShallowestRiver(List<River> rivers) {
        return rivers.stream()
                .min(Comparator.comparingDouble(River::getDepth))
                .map(River::getName)
                .orElse("");
    }
}
