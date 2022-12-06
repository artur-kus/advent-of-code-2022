import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        Path filePath = Paths.get(ClassLoader.getSystemResource("input.txt").toURI());
        List<String> file = Files.readAllLines(filePath);
        List<Operation> operations = file.stream().map(Operation::new).collect(Collectors.toList());
        solvePartOne(new Stacks().get(), operations);
        solveSecondPart(new Stacks().get(), operations);
    }

    private static void solvePartOne(List<Stack<Character>> model, List<Operation> operations) {
        for (Operation operation : operations) {
            int howMany = operation.getHowMany();
            Stack<Character> stackFrom = model.get((operation.getFrom() - 1));
            Stack<Character> stackTo = model.get((operation.getTo() - 1));
            for (int i = 0; i < howMany; i++) {
                stackTo.push(stackFrom.pop());
            }
        }
        System.out.println("Part one solution: ");
        model.forEach(s -> System.out.print(s.pop()));
        System.out.println(System.lineSeparator());
    }

    private static void solveSecondPart(List<Stack<Character>> model, List<Operation> operations) {
        for (Operation operation : operations) {
            int howMany = operation.getHowMany();
            Stack<Character> stackFrom = model.get((operation.getFrom() - 1));
            Stack<Character> stackTo = model.get((operation.getTo() - 1));
            Stack<Character> stackInverse = new Stack<>();
            for (int i = 0; i < howMany; i++) {
                stackInverse.push(stackFrom.pop());
            }
            for (int i = 0; i < howMany; i++) {
                stackTo.push(stackInverse.pop());
            }
        }
        System.out.println("Part two solution: ");
        model.forEach(s -> System.out.print(s.pop()));
        System.out.println(System.lineSeparator());
    }
}
