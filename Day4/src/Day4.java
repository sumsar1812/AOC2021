import java.io.IOException;

public class Day4 extends AOCPuzzle {

    public static void main(String[] args) throws IOException {
        Day4 day4 = new Day4();
        day4.run();
    }

    public Day4() throws IOException {
        super("day4");
    }

    @Override
    public String solve() {
        return null;
    }

    @Override
    public void run() {
        String drawnNumbersString = getData().get(0);
        BoardLoader boardLoader = new BoardLoader();
        boardLoader.loadBoards(getData().subList(1, getData().size()));
        for (String s : drawnNumbersString.split(",")) {
            if (boardLoader.checkBoards(Integer.parseInt(s))) {
                System.out.println("All boards has atleast one row/column finished");
                return;
            }
        }
    }
}
