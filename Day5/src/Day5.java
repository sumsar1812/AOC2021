import java.io.IOException;

public class Day5 extends AOCPuzzle {
    public Day5() throws IOException {
        super("day5");
    }

    @Override
    public String solve() {
        return null;
    }

    @Override
    public void run() {
        PointLoader pointLoader = new PointLoader();
        pointLoader.loadPoints(getData());
    }


    public static void main(String[] args) throws IOException {
        Day5 day5 = new Day5();
        day5.run();
    }
}
