import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
        aplhabet.keySet().forEach(v -> {
            if ((items.contains(v))) {
                System.out.println("LITERA: " + v + ", punktów: " + aplhabet.get(v));
            }
        });
        System.out.println("\nWynik: " + result);

        result = 0;

        List<List<String>> elvesGroups = getElvesGroups(lines);

        for (List<String> group : elvesGroups) {
            Map<String, Long> itemType = new HashMap<>();
            for (String backpack : group) {
                Set<String> actualItems = new HashSet<>();
                for (int i = 0; i < backpack.length(); i++) {
                    String item = backpack.substring(i, i + 1);
                    if (!actualItems.contains(item)) {
                        actualItems.add(item);
                        itemType.compute(item, (key, val) -> (val != null) ? val + 1L : 1L);
                    }
                }
                if (group.get(2).equals(backpack)) {
                    itemType.entrySet().removeIf(entry -> entry.getValue() < 3);

                    for (String badge : itemType.keySet()) {
                        result += aplhabet.get(badge);
                    }
                }
            }
        }
        System.out.println("Wynik drugiego zadania: " + result);
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

    private static List<List<String>> getElvesGroups(List<String> lines) {
        List<List<String>> groupsElves = new ArrayList<>();
        List<String> group = new ArrayList<>();
        for (String line : lines) {
            if (group.size() <= 2) {
                group.add(line);
                if (group.size() == 3) {
                    groupsElves.add(new ArrayList<>(group));
                    group.clear();
                }
            }
        }
        return groupsElves;
    }
}

