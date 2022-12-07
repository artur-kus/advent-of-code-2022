import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path filePath = Paths.get(ClassLoader.getSystemResource("input.txt").toURI());
        List<String> file = Files.readAllLines(filePath);
        //PART ONE
        solve(file.get(0), 4);
        //PART TWO
        solve(file.get(0), 14);
    }

    private static void solve(String line, int markerLenght) {
        for (int i = 0; i < line.length(); i++) {
            String substring = line.substring(i, i + markerLenght);
            Set<Character> checker = substring.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
            if (checker.size() == markerLenght) {
                System.out.println(i+markerLenght);
                break;
            }
        }
    }
}
