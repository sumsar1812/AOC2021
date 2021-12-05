public class Day5 extends Day{
    public Day5() {
        super("day5");
    }

    @Override
    public void run() {
        PointLoader pointLoader = new PointLoader();
        pointLoader.loadPoints(getData());
    }


    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.run();
    }
}
