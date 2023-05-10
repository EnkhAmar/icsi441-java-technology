package lab14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicates {
    List<Integer> list = List.of(2, 5, 6, 5, 4, 3, 23, 43, 2, 0);
    HashMap<Integer, Integer> map = new HashMap<>();
    public CountDuplicates() {
        Map<Integer, Long> occurrenceMap = list.stream()
                .filter(e -> e > 0 && e < 51)
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        for (Map.Entry<Integer, Long> entry : occurrenceMap.entrySet()) {
            int num = entry.getKey();
            long count = entry.getValue();
            String times = count == 1 ? "time" : "times";
            System.out.println(num + " occurs " + count + " " + times);
        }
    }
    public static void main(String[] args) {
        new CountDuplicates();
    }
}
