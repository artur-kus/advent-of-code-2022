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
        String line = file.get(0);
        for (int i = 0; i < line.length(); i++) {
            String substring = line.substring(i, i + 4);
            Set<Character> checker = substring.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
            if (checker.size() == 4) {
                System.out.println(i+4);
                break;
            }
        }
    }
}
