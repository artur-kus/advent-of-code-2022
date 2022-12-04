import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        long result = 0;
        List<String> file = Files.readAllLines(Path.of("E://KURS/advent-of-code/advent-of-code/day4/src/main/resources/input.txt"));
        for (String line : file) {
            List<String> elves = Arrays.stream(line.split(",")).collect(Collectors.toList());
            Range firstRange = getRange(elves.get(0));
            Range secondRange = getRange(elves.get(1));
            if (isInRange(firstRange, secondRange) || isInRange(secondRange, firstRange)) result++;
        }
        System.out.println("Wynik pierwszego zadania: " + result);
    }

    private static boolean isInRange(Range firstRange, Range secondRange) {
        return (firstRange.getFrom() <= secondRange.getFrom() && firstRange.getTo() >= secondRange.getTo());
    }

    private static Range getRange(String elf) {
        List<String> rangeList = Arrays.stream(elf.split("-")).collect(Collectors.toList());
        return new Range(rangeList);
    }

    private static class Range {
        private Long from;
        private Long to;

        public Range(List<String> rangeList) {
            this.from = Long.parseLong(rangeList.get(0));
            this.to = Long.parseLong(rangeList.get(1));
        }

        public Long getFrom() {
            return from;
        }

        public void setFrom(Long from) {
            this.from = from;
        }

        public Long getTo() {
            return to;
        }

        public void setTo(Long to) {
            this.to = to;
        }
    }

}
