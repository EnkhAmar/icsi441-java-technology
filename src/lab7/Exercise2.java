package lab7;

/*
К ширхэг тойрог объект үүсгэн ямар нэг цуглуулгад хадгална.
1. Эдгээр тойрог объектуудыг талбайг хэвлэнэ. Ингэхдээ iterator хэрэглэнэ.
2. Ижил радиустай тойргуудыг хэвлэнэ.
3. Тойргуудын талбайны утгаар нь урвуугаар эрэмбэлнэ.
 */

import java.util.*;

public class Exercise2 {
    LinkedList<Circle> circles;

    public Exercise2(int num) {
        circles = new LinkedList<>();
        generateCircles(num);

        System.out.println("TASK 1 - PRINT AREAS");
        printAreas();
        System.out.println("TASK 2 - EQUAL RADIUS");
        printEqualRadius();

        System.out.println("TASK 3 - PRINT REVERSE BY AREA");
        printReverse();
    }

    void printAreas() {
        Iterator<Circle> iterator = circles.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getArea());
        }
    }

    void printEqualRadius() {
        // group circles by radius value
        HashMap<Double, ArrayList<Circle>> map = new HashMap<>();
        for (Circle circle : circles) {
            double radius = circle.getRadius();
            if (!map.containsKey(radius)) {
                map.put(radius, new ArrayList<>());
            }
            map.get(radius).add(circle);
        }

        // print circles with equal radius within them
        for (ArrayList<Circle> list : map.values()) {
            if (list.size() > 1) {
                System.out.println("Circles with radius " + list.get(0).getRadius() + ":");
                for (Circle circle : list) {
                    System.out.println(circle);
                }
            }
        }
    }

    void printReverse() {
        Collections.sort(circles, new Comparator<Circle>() {
            public int compare(Circle c1, Circle c2) {
                return Double.compare(c2.getArea(), c1.getArea());
            }
        });
        for (Circle c : circles) {
            System.out.println(c.getArea());
        }
    }

    void generateCircles(int num) {
        int radius;
        while (--num>0) {
            radius = generateRandomInt(1, 10);
            Circle circle = new Circle(radius);
            circles.add(circle);
        }
    }

    static int generateRandomInt(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return  randomNumber;
    }

    public static void main(String[] args) {
        new Exercise2(10);
    }
}
