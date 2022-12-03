import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        long result = 0;
        Map<String, Long> aplhabet = getAplhabet();
        List<String> items = new ArrayList<>();

        List<String> lines = Files.readAllLines(Path.of("E://KURS/advent-of-code/advent-of-code/day3/src/main/resources/input.txt"));
        for (String line : lines) {
            int length = line.length();
            List<String> duplicateCharacters = checkDuplicateCharacters(line);
            String firstBackpack = line.substring(0, length / 2);
            String secondBackpack = line.substring(length / 2, length);
            for (String duplicateCharacter : duplicateCharacters) {
               if (firstBackpack.contains(duplicateCharacter) && (secondBackpack.contains(duplicateCharacter))) {
                   result += aplhabet.get(duplicateCharacter);
                   items.add(duplicateCharacter);
               }

            }
        }
        System.out.println("LITERY: " + items + "\n");
        aplhabet.keySet().forEach(v ->{
            if ((items.contains(v))){
                System.out.println("LITERA: " + v + ", punktów: " + aplhabet.get(v));
            }
        });
        System.out.println("\nWynik: " + result);
    }

    private static List<String> checkDuplicateCharacters(String line) {
        Map<String, Long> helper = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            String firstCharacter = line.substring(i, i + 1);
            helper.merge(firstCharacter, 1L, Long::sum);
        }
        helper.entrySet().removeIf(entry -> entry.getValue().equals(1L));
        return new ArrayList<>(helper.keySet());
    }

    private static Map<String, Long> getAplhabet() {
        Map<String, Long> alphabet = new HashMap<>();
        char actual;
        long priority = 1;
        for (actual = 'a'; actual <= 'z'; ++actual)
            alphabet.put(String.valueOf(actual), priority++);
        for (actual = 'A'; actual <= 'Z'; ++actual)
            alphabet.put(String.valueOf(actual), priority++);
        return alphabet;
    }
}

