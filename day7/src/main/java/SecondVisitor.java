import java.util.List;

public interface SecondVisitor {

    void visit(Tree tree);

    List<Tree> getDirectories();
}
