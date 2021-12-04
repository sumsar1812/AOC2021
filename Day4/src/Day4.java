import java.util.List;

public class Day4 extends Day {

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        day4.run();
    }

    public Day4() {
        super("day4");
    }

    @Override
    public void run() {
        String drawnNumbersString = getData().get(0);
        BoardLoader boardLoader = new BoardLoader();
        boardLoader.loadBoards(getData().subList(1, getData().size()));
        for (String s : drawnNumbersString.split(",")) {
            boardLoader.checkBoards(Integer.parseInt(s));
        }
    }
}
