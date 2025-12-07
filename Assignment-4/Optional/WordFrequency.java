// ===========================================================================================
// 6. Count occurrences of each word in a line/file.
// ===========================================================================================

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

    public static void countWords(String text) {
        String cleanText = text.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] words = cleanText.split("\\s+");
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            if (word.length() > 0) {
                if (wordMap.containsKey(word)) {
                    wordMap.put(word, wordMap.get(word) + 1);
                } else {
                    wordMap.put(word, 1);
                }
            }
        }

        System.out.println("Word Counts:");
        System.out.println("-----------------");
        for (String key : wordMap.keySet()) {
            System.out.println(key + ": " + wordMap.get(key));
        }
    }

    public static void main(String[] args) {
        String line = "Java is fun. Java is powerful. Fun is good!";

        System.out.println("Input: " + line);
        countWords(line);
    }
}
