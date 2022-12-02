import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<Integer, Long> result = new HashMap<>();
        int counter = 1;
        long value = 0;

        List<String> lines = Files.readAllLines(Path.of("E://KURS/advent-of-code/advent-of-code/src/main/resources/input.txt"));
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                result.put(counter, value);
                counter++;
                value = 0;
            } else {
                value += Long.parseLong(line);
            }
        }

        long maxResult = result.values().stream().max(Comparator.comparingLong(x -> x)).orElseThrow(NoSuchElementException::new);
        System.out.println("MAKSYMALNA WARTOSC: " + maxResult);

        long collect = result.values()
                .stream()
                .sorted(Comparator.reverseOrder()).limit(3).mapToLong(x -> x).sum();
        System.out.println("SUMA TRZECH NAJWIEKSZYCH LICZBY Z MAPY: " + collect);
    }
}