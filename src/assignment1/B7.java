package assignment1;

import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
/*
B7. Адил урттай хоёр үгийн хоорондох зайг ол. Энэ зай гэдэг нь энэ
хоёр үг дэх ялгаатай үсгийг тоог хэлнэ. Өгөгдсөн өгүүлбэрээс өгөгдсөн
урттай хоорондоо хамгийн хол зайтай байх хоёр үгийг ол
 */
public class B7 {
    class Result {
        String[] words = new String[2];
        int maxDistance = 0;

        public Result(String[] words, int maxDistance) {
            this.words = words;
            this.maxDistance = maxDistance;
        }
    }

    public B7() {
        System.out.println("Enter: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        Result result = findFurthestWords(sentence);
        if (result.words != null) {
            System.out.println("furthest words: " + result.words[0] + ", " + result.words[1]);
            System.out.println("max distance: " + result.maxDistance);
        } else {
            System.out.println("No two words of the same length were found.");
        }
    }

    public static void main(String[] args) {
        new B7();
    }
    public Result findFurthestWords(String sentence) {
        String[] words = sentence.split("\\s+");
        String[] furthestWords = null;
        int maxDistance = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (words[i].length() == words[j].length()) {
                    int distance = 0;
                    for (int k = 0; k < words[i].length(); k++) {
                        if (words[i].charAt(k) != words[j].charAt(k)) {
                            distance++;
                        }
                    }
                    if (distance > maxDistance) {
                        maxDistance = distance;
                        furthestWords = new String[]{words[i], words[j]};
                    }
                }
            }
        }
        Result result = new Result(furthestWords, maxDistance);
        return result;
    }

}
