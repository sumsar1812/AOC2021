import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoardLoader {

    private List<Board> boards;

    public void loadBoards(List<String> allData) {
        List<List<Integer>> boardNumbers = new ArrayList<>();
        boards = new ArrayList<>();
        for (int i = 0; i < allData.size(); i++) {
            final String numString = allData.get(i);
            if (numString.isEmpty()) {
                continue;
            }
            final List<Integer> numbers = Arrays.stream(numString.split(" "))
                    .filter(l -> !l.isEmpty())
                    .map(v -> Integer.parseInt(v.trim()))
                    .collect(Collectors.toList());
            boardNumbers.add(numbers);
            if (boardNumbers.size() == 5) {
                boards.add(new Board(boardNumbers));
                boardNumbers.clear();
            }
        }
    }

    public void checkBoards(int num) {
        System.out.println("checking num: " + num);
        for (Board board : boards) {
            if (board.tryMark(num)) {
                if (board.hasFinishedRow()) {
                    System.out.println("score: " + board.getScore(num));
                } else if (board.hasFinishedColumn()) {
                    System.out.println("score: " + board.getScore(num));

                }
            }
        }
    }
}
