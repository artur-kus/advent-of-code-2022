import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {

        final String dirRegex = ".*dir.*";
        final String leafRegex = "([0-9].{1,})";
        final String cdRegex = "(\\$.cd\\s{1,}[a-zA-Z]{1,})";

        Path filePath = Paths.get(ClassLoader.getSystemResource("input.txt").toURI());
        List<String> file = Files.readAllLines(filePath);
        Tree root = new Tree("root");
        Tree actualPosition = root;
        for (String line : file) {
            if (line.matches(leafRegex)) {
                List<String> splitLine = Arrays.stream(line.split(" ")).toList();
                actualPosition.addLeaf(new File(splitLine));
            } else if (line.matches(".*cd\s.{2}")) {
                if (actualPosition.getUpperFolder() != null) {
                    actualPosition = actualPosition.getUpperFolder();
                }
            } else if (line.matches(cdRegex)) {
                String folderName = line.replaceAll("\\$.cd\\s{1,}", "");
                Optional<Tree> folder = actualPosition.findFolder(folderName);
                if (folder.isEmpty()) {
                    actualPosition.getChildren().add(new Tree(folderName));
                } else actualPosition = folder.get();
            } else if (line.matches(dirRegex)) {
                String folderName = line.replaceAll(".*dir\\s{1,}", "");
                if (actualPosition.findFolder(folderName).isEmpty()) {
                    actualPosition.addChild(new Tree(folderName));
                }
            }
        }

        Visitor visitor = new Visitor() {
            long finalResult;

            @Override
            public void visit(Tree tree) {
                long result = tree.getSize();
                if (result < 100000) {
                    finalResult += result;
                    System.out.println(tree.getFolderName() + " " + result);
                }
            }

            @Override
            public long getResult() {
                return finalResult;
            }
        };
        root.accept(visitor);
        System.out.println(visitor.getResult());
    }
}