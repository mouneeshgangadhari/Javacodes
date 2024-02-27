import java.util.ArrayList;
import java.util.List;

public class GenerateAbbreviations {
    public static List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        backtrack(result, word, 0, "", 0);
        return result;
    }

    private static void backtrack(List<String> result, String word, int index, String current, int count) {
        if (index == word.length()) {
            if (count > 0) {
                current += count;
            }
            result.add(current);
            return;
        }

        // Abbreviate the current character
        backtrack(result, word, index + 1, current, count + 1);

        // Do not abbreviate the current character, reset count
        backtrack(result, word, index + 1, current + (count > 0 ? count : "") + word.charAt(index), 0);
    }

    public static void main(String[] args) {
        String word = "kmit";
        List<String> abbreviations = generateAbbreviations(word);
        System.err.println(abbreviations);
    }
}
