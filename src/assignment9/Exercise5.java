package assignment9;

import java.util.stream.IntStream;

// @student: G.Enkh-Amar
/*
Эхний  гурван цифрийн  нийлбэр  нь  сүүлийн  гурван  цифрийн  нийлбэртэй  тэнцүү  байх тасалбарыг “азтай” гэнэ.
Цифрүүдийн  нийлбэр  нь  13  байдаг  азтай  тасалбарын  тоог тодорхойл. Билетын дугаар нь 000000-аас 999999
хооронд байж болно.
 */
public class Exercise5 {
    public static void main(String[] args) {
        int count = countLuckyTickets();

        System.out.println("Цифрүүдийн  нийлбэр  нь  13  байдаг  азтай  тасалбарын  тоо: " + count);
    }

    private static int countLuckyTickets() {
        return (int) IntStream.rangeClosed(0, 999999)
                .filter(Exercise5::isLuckyTicket)
                .count();
    }

    private static boolean isLuckyTicket(int ticket) {
        int firstHalfSum = sumDigits(ticket / 1000);
        int secondHalfSum = sumDigits(ticket % 1000);
        return firstHalfSum == secondHalfSum && firstHalfSum == 13;
    }

    private static int sumDigits(int number) {
        return String.valueOf(number).chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
