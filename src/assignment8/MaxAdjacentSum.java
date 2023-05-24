package assignment8;

import java.util.Arrays;
import java.util.stream.IntStream;

// @student: G.Enkh-Amar /18b1num0399/
/*
Эерэг бүхэл тоон утгууд агуулах массив өгөгдөв. Зэргэлдээ орших тооны утгуудаас
нийлбэр нь хамгийн их байдаг утгыг ол. Жишээ нь, массивт 1000 тоо агуулдаг гэвэл
зэрэгцээ орших 10 тоонууд бүрийн хувьд нийлбэр утга нь их байх дарааллыг олно.
 */

public class MaxAdjacentSum {
    public static int[] findMaxAdjacentSumImperative(int[] arr, int adjacentLength) {
        int maxIndex = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - adjacentLength; i++) {
            int currentSum = 0;
            for (int j = i; j < i + adjacentLength; j++) {
                currentSum += arr[j];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxIndex = i;
            }
        }

        return Arrays.copyOfRange(arr, maxIndex, maxIndex + adjacentLength);
    }

    public static int[] findMaxAdjacentSum(int[] arr, int adjacentLength) {
        int[] result = Arrays.stream(IntStream.range(0, arr.length - adjacentLength + 1)
                        .mapToObj(i -> Arrays.copyOfRange(arr, i, i + adjacentLength))
                        .reduce((a, b) -> {
                            int sumA = Arrays.stream(a).sum();
                            int sumB = Arrays.stream(b).sum();
                            return sumA > sumB ? a : b;
                        })
                        .orElse(new int[0]))
                .toArray();

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 3, 7, 4, 9, 6, 0, 10};
        int adjacentLength = 10;
        int[] result = findMaxAdjacentSum(arr, adjacentLength);
        System.out.println("The sequence with the greatest adjacent sum is: " + Arrays.toString(result));
    }
}
