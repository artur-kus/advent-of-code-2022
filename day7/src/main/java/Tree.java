import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Tree {
    private String folderName;
    private Tree parent;
    private List<File> leaf = new ArrayList<>();
    private List<Tree>  children = new LinkedList<>();


    public Tree(String folderName) {
        this.folderName = folderName;
    }

    public void accept(Visitor v) {
        v.visit(this);
        for (Tree e : this.children) {
            e.accept(v);
        }
    }

    public Optional<Tree> findFolder(String folderName) {
        return this.getChildren().stream()
                .filter(c -> c.getFolderName().equals(folderName))
                .findAny();
    }

    public void addLeaf(File leaf) {
        this.leaf.add(leaf);
    }

    public Tree addChild(Tree child) {
        child.parent = this;
        this.children.add(child);
        return child;
    }

    public long getSize() {
        long result = getLeaf().stream().collect(Collectors.summarizingLong(File::getSize)).getSum();
        for (Tree tree : getChildren()) {
            result += tree.getSize();
        }
        return result;
    }

    public Tree getUpperFolder() {
        return this.parent;
    }

    public String getFolderName() {
        return folderName;
    }

    public List<File> getLeaf() {
        return leaf;
    }

    public List<Tree> getChildren() {
        return children;
    }
}