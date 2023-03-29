package assignment5;

import java.util.*;

public class Delivery {
    public static void main(String[] args) {
        // Create M boxes of different sizes
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(2, 3, 4));
        boxes.add(new Box(3, 4, 5));
        boxes.add(new Box(4, 5, 6));

        // Create corresponding HeavyBox objects with random weights
        List<HeavyBox> heavyBoxes = new ArrayList<>();
        Random rand = new Random();
        for (Box box : boxes) {
            heavyBoxes.add(new HeavyBox(box, rand.nextInt(50) + 1));
        }

        // Sort the heavy boxes by weight
        Collections.sort(heavyBoxes, Comparator.comparingInt((HeavyBox hb) -> hb.weight));

        // Distribute the boxes and calculate the total weight of each delivery
        List<List<HeavyBox>> deliveries = new ArrayList<>();
        int totalWeight = 0;
        List<HeavyBox> currentDelivery = new ArrayList<>();
        for (HeavyBox hb : heavyBoxes) {
            if (totalWeight + hb.weight > 100) {
                deliveries.add(currentDelivery);
                currentDelivery = new ArrayList<>();
                totalWeight = 0;
            }
            currentDelivery.add(hb);
            totalWeight += hb.weight;
        }
        if (!currentDelivery.isEmpty()) {
            deliveries.add(currentDelivery);
        }

        // Print the deliveries
        int i = 1;
        for (List<HeavyBox> delivery : deliveries) {
            System.out.println("Delivery " + i + ":");
            for (HeavyBox hb : delivery) {
                System.out.println("\t" + hb);
            }
            System.out.println("\tTotal weight: " + delivery.stream().mapToInt(hb -> hb.weight).sum() + " kg\n");
            i++;
        }
    }
}
