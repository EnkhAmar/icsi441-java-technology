package assignment8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;

public class FirstUniqueCharacter {
    public static char findFirstUniqueCharacterImperative(String sentence) {
        // Create a HashMap to store the count of each character
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count the occurrences of each character in the sentence
        for (char c : sentence.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Find the first character with count 1 in the sentence
        for (char c : sentence.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                return c;
            }
        }

        // If no unique character is found, return a default value
        return '\0';
    }

    public static char findFirstUniqueCharacter(String sentence) {
        // Create a LinkedHashMap to preserve the order of character insertion
        Map<Character, Long> charCountMap = sentence.chars()
                .mapToObj(c -> (char) c)
                .collect(LinkedHashMap::new, (map, c) -> map.merge(c, 1L, Long::sum), LinkedHashMap::putAll);

        // Find the first character with count 1 in the sentence
        Optional<Character> firstUniqueChar = charCountMap.keySet().stream()
                .filter(c -> charCountMap.get(c) == 1)
                .findFirst();

        // Return the first unique character if found, or a default value otherwise
        return firstUniqueChar.orElse('\0');
    }

    public static void main(String[] args) {
        String sentence = "A sentence was given. Write a program to find the first unique character in this sentence.";
        char firstUniqueChar = findFirstUniqueCharacter(sentence);

        if (firstUniqueChar != '\0') {
            System.out.println("The first unique character is: " + firstUniqueChar);
        } else {
            System.out.println("No unique character found in the sentence.");
        }
    }
}

