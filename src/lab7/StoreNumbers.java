package lab7;

import java.util.*;

// @student: G.Enkh-Amar
/* 20.2
(Store numbers in a linked list) Write a program that lets the user enter numbers from a graphical user interface and displays them in a text area, as shown
in Figure 20.17a. Use a linked list to store the numbers. Do not store duplicate numbers. Add the buttons Sort, Shuffle, and Reverse to sort, shuffle, and
reverse the list.
 */
public class StoreNumbers {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set = input(set);
        System.out.println(set);
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

    static LinkedHashSet<Integer> input(LinkedHashSet<Integer> set) {
        Scanner scanner = new Scanner(System.in);
        int temp;
        while (true) {
            temp = scanner.nextInt();
            if (temp < 0) break;
            set.add(temp);
        }
        return set;
    }
}
