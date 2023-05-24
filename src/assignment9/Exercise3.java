package assignment9;

import java.util.OptionalInt;
import java.util.stream.Stream;

/*
Локатор нь («Х» –хойд, «У» –урд, «Б» –баруун, «З» –зүүн) дөрвөн зүгийн аль нэгийг
заах ба дараах командыг хүлээн авдаг:
«1» бол баруун тийш 90ºэргэх,
«-1» бол зүүн тийш эргэх (–90º),
«2» бол эсрэг чигт (180º)-аар эргэх (180º).
Анх локатор хойд зүгт харж байрласан байв.
Хэд хэдэн команд оруулсны дараа локатор аль зүгт харсан байх вэ.
 */
public class Exercise3 {
    public static void main(String[] args) {
        String commands = "1 2 -1 1";

        char direction = calculateDirection(commands);

        System.out.println("Final direction: " + direction);
    }

    public static char calculateDirection(String commands) {
        char[] directions = {'X', 'Y', 'B', 'Z'};
        char initialDirection = 'X'; // Initial direction is north

        OptionalInt finalDirectionIndex = Stream.of(commands.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .reduce((a, b) -> updateDirection(directions[a], b));

        int finalDirectionIndexValue = finalDirectionIndex.orElseGet(() -> indexOfDirection(initialDirection, directions));
        return directions[finalDirectionIndexValue];
    }

    public static int updateDirection(char currentDirection, int angleChange) {
        char[] directions = {'X', 'Y', 'B', 'Z'};
        int currentIndex = indexOfDirection(currentDirection, directions);
        int newIndex = (currentIndex + angleChange / 90) % 4;
        if (newIndex < 0) {
            newIndex += 4;
        }
        return newIndex;
    }

    public static int indexOfDirection(char direction, char[] directions) {
        for (int i = 0; i < directions.length; i++) {
            if (direction == directions[i]) {
                return i;
            }
        }
        return -1;
    }
}
