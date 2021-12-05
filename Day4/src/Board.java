import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final List<List<BoardNumber>> boardNumbers = new ArrayList<>();
    private boolean finished = false;


    public Board(List<List<Integer>> boardData) {
        for (List<Integer> data : boardData) {
            List<BoardNumber> boardNumbers = new ArrayList<>();
            for (Integer number : data) {
                boardNumbers.add(new BoardNumber(number));
            }
            this.boardNumbers.add(boardNumbers);
        }
    }

    public boolean hasFinishedRow() {
        if (finished) { //To avoid completing the same boards twice
            return false;
        }
        int line = 0;
        for (List<BoardNumber> boardNumber : boardNumbers) {
            if (boardNumber.stream().allMatch(BoardNumber::isMarked)) {
                System.out.println("row match: " + line + " - " + boardNumber.stream()
                        .map(i -> String.valueOf(i.getNumber()))
                        .collect(Collectors.joining(",")));
                finished = true;
                return true;
            }
            line++;
        }
        return false;
    }
    public boolean hasFinishedColumn() {
        if (finished) { //To avoid completing the same boards twice
            return false;
        }
        int column = 0;
        for (int i = 0; i < 5; i++) {
            int matches = 0;
            List<Integer> winnerNums = new ArrayList<>();
            for (int k = 0; k < 5; k++) {
                final BoardNumber boardNumber = boardNumbers.get(k).get(i);
                if (boardNumber.isMarked()) {
                    winnerNums.add(boardNumber.getNumber());
                    matches++;
                }
            }
            if (matches == 5) {
                finished = true;
                System.out.println("column match: " + column + " - " + winnerNums.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));
                return true;
            }
            column++;
        }
        return false;
    }

    public boolean tryMark(int num) {
        final BoardNumber boardNumber = boardNumbers.stream().flatMap(Collection::stream).filter(i -> i.getNumber() == num).findFirst().orElse(null);
        if (boardNumber == null) {
            return false;
        }
        boardNumber.mark();
        return true;
    }


    public int getScore(int lastDraw) {
        return boardNumbers.stream().flatMap(Collection::stream).filter(i -> !i.isMarked()).mapToInt(BoardNumber::getNumber).sum() * lastDraw;
    }

    public void print() {
        for (List<BoardNumber> boardNumber : boardNumbers) {
            final String line = boardNumber.stream().map(v -> String.valueOf(v.getNumber())).collect(Collectors.joining(","));
            System.out.println(line);
        }
        System.out.println();
    }

}
