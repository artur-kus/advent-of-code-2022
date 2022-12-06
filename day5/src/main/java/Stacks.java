import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stacks {
    public List<Stack<Character>> get() {
        // 1   2   3   4   5   6   7   8   9
        //[R] [N] [S] [T] [P] [P] [W] [Q] [G]
        //[S] [Z] [M] [G] [H] [C] [C] [H] [Z]
        //[L] [Q] [Q] [Z] [M] [Q] [F] [G] [D]
        //[F] [G] [B] [J] [B] [N]     [Z] [L]
        //[Q] [P]     [H] [N] [S]     [W] [C]
        //    [T]     [C] [F] [L]     [V] [N]
        //            [B] [S] [V]     [P] [R]
        //            [Q]     [G]     [M]

        List<Stack<Character>> stacks = new ArrayList<>();

        stacks.add(new Stack<>());
        stacks.get(0).push('R');
        stacks.get(0).push('S');
        stacks.get(0).push('L');
        stacks.get(0).push('F');
        stacks.get(0).push('Q');

        stacks.add(new Stack<>());
        stacks.get(1).push('N');
        stacks.get(1).push('Z');
        stacks.get(1).push('Q');
        stacks.get(1).push('G');
        stacks.get(1).push('P');
        stacks.get(1).push('T');

        stacks.add(new Stack<>());
        stacks.get(2).push('S');
        stacks.get(2).push('M');
        stacks.get(2).push('Q');
        stacks.get(2).push('B');

        stacks.add(new Stack<>());
        stacks.get(3).push('T');
        stacks.get(3).push('G');
        stacks.get(3).push('Z');
        stacks.get(3).push('J');
        stacks.get(3).push('H');
        stacks.get(3).push('C');
        stacks.get(3).push('B');
        stacks.get(3).push('Q');

        stacks.add(new Stack<>());
        stacks.get(4).push('P');
        stacks.get(4).push('H');
        stacks.get(4).push('M');
        stacks.get(4).push('B');
        stacks.get(4).push('N');
        stacks.get(4).push('F');
        stacks.get(4).push('S');

        stacks.add(new Stack<>());
        stacks.get(5).push('P');
        stacks.get(5).push('C');
        stacks.get(5).push('Q');
        stacks.get(5).push('N');
        stacks.get(5).push('S');
        stacks.get(5).push('L');
        stacks.get(5).push('V');
        stacks.get(5).push('G');

        stacks.add(new Stack<>());
        stacks.get(6).push('W');
        stacks.get(6).push('C');
        stacks.get(6).push('F');

        stacks.add(new Stack<>());
        stacks.get(7).push('Q');
        stacks.get(7).push('H');
        stacks.get(7).push('G');
        stacks.get(7).push('Z');
        stacks.get(7).push('W');
        stacks.get(7).push('V');
        stacks.get(7).push('P');
        stacks.get(7).push('M');

        stacks.add(new Stack<>());
        stacks.get(8).push('G');
        stacks.get(8).push('Z');
        stacks.get(8).push('D');
        stacks.get(8).push('L');
        stacks.get(8).push('C');
        stacks.get(8).push('N');
        stacks.get(8).push('R');

        return stacks;
    }
}
