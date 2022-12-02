import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {

        long value = 0;
        long secondTaskResult = 0;

        List<String> lines = Files.readAllLines(Path.of("E://KURS/advent-of-code/advent-of-code/day2/src/main/resources/input.txt"));
        for (String line : lines) {
            Action opponent = Action.fromString(line.substring(0, 1));
            Action user = Action.fromString(line.substring(2, 3));
            value += calculateScore(Objects.requireNonNull(user), opponent);
            secondTaskResult += calculateSecondTask(user, opponent);
        }
        System.out.println("First task: " + value + "\n" + "Second: " + secondTaskResult);
    }

    private static long calculateSecondTask(Action user, Action opponent) {
        if (user.getStatus().equals(Status.WIN)) {
            return switch (opponent) {
                case ROCK -> Action.PAPER.getScore() + 6;
                case PAPER -> Action.SCISSORS.getScore() + 6;
                case SCISSORS -> Action.ROCK.getScore() + 6;
            };
        } else if (user.getStatus().equals(Status.LOSE)) {
            return switch (opponent) {
                case ROCK -> Action.SCISSORS.getScore();
                case PAPER -> Action.ROCK.getScore();
                case SCISSORS -> Action.PAPER.getScore();
            };
        } else return opponent.getScore() + 3;
    }

    private static long calculateScore(Action user, Action opponent) {
        if (user.equals(Action.ROCK) && opponent.equals(Action.PAPER)
                || (user.equals(Action.PAPER) && opponent.equals(Action.SCISSORS))
                || (user.equals(Action.SCISSORS) && opponent.equals(Action.ROCK))) {
            return user.getScore();
        } else if (user.equals(Action.PAPER) && opponent.equals(Action.ROCK)
                || (user.equals(Action.ROCK) && opponent.equals(Action.SCISSORS))
                || (user.equals(Action.SCISSORS) && opponent.equals(Action.PAPER))) {
            return user.getScore() + 6;
        } else return user.getScore() + 3;
    }

    private enum Status {
        LOSE, DRAW, WIN
    }

    private enum Action {
        ROCK("A", "X", 1, Status.LOSE),
        PAPER("B", "Y", 2, Status.DRAW),
        SCISSORS("C", "Z", 3, Status.WIN);

        private final String user;
        private final String opponent;
        private final int score;
        private final Status status;

        Action(String user, String opponent, int score, Status status) {
            this.user = user;
            this.opponent = opponent;
            this.score = score;
            this.status = status;
        }

        public String getUser() {
            return user;
        }

        public String getOpponent() {
            return opponent;
        }

        public int getScore() {
            return score;
        }

        public Status getStatus() {
            return status;
        }

        public static Action fromString(String text) {
            for (Action action : Action.values()) {
                if (action.getUser().equalsIgnoreCase(text)) {
                    return action;
                } else if (action.getOpponent().equalsIgnoreCase(text)) {
                    return action;
                }
            }
            return null;
        }
    }
}
