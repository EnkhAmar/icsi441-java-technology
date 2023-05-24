package assignment9;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// @student: G.Enkh-Amar
/*
Дараах өгөгдөл хадгалдаг бинар файл өгөгдөв:
-Интернэтийн үйлчилгээ авдаг үйлчлүүлэгчийн нэр;
-Интернэтийн хурд 1 Мбит/сек бол сард төлөх үйлчилгээний төлбөрийн хэмжээ;
-Интернэтийн үйлчилгээ авсан сарын тоо;
-Интернэтийн үйлчилгээний төлбөрийг урьдчилж төлсөн сарын тоо
Хэрэв 3 сарын төлбөрийг урьдчилж төлбөл 1 Мбит/сек хурдтай үйлчилгээний үнэ 7%-иар хямдардаг.
Тэгвэл хямдралгүй төлөх үнийн дүнгээс ямар зөрүүтэй байх бэ?
 */

public class InternetService {
    public static void main(String[] args) {
        String filename = "src/assignment9/exercise7_client_info.obj";

        // Create dummy data if the file does not exist
        if (!fileExists(filename)) {
            createDummyClientInfoFile(filename);
        }

        // Calculate the price difference using functional programming
        double priceDifference = calculatePriceDifference(filename);
        System.out.println("Price difference: " + priceDifference);
    }

    private static boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    private static void createDummyClientInfoFile(String filename) {
        List<InternetClient> clients = Arrays.asList(
                new InternetClient("Client A", 50.0, 12, 3),
                new InternetClient("Client B", 80.0, 6, 2),
                new InternetClient("Client C", 100.0, 9, 1)
        );

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (InternetClient client : clients) {
                objectOutputStream.writeObject(client);
            }
            System.out.println("Dummy client_info.obj file created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calculatePriceDifference(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return Stream.generate(() -> {
                        try {
                            return (InternetClient) objectInputStream.readObject();
                        } catch (EOFException e) {
                            return null;
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .takeWhile(Objects::nonNull)
                    .mapToDouble(client -> {
                        double totalFee = client.getMonthlyFee() * client.getMonthsOfService();
                        double discountedFee = calculateDiscountedFee(client);
                        return discountedFee - totalFee;
                    })
                    .sum();
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    private static double calculateDiscountedFee(InternetClient client) {
        if (client.getMonthsPrepaid() >= 3) {
            double discountedFee = client.getMonthlyFee() * client.getMonthsOfService();
            discountedFee *= (1 - 0.07); // Apply 7% discount
            return discountedFee;
        } else {
            return client.getMonthlyFee() * client.getMonthsOfService();
        }
    }
}