import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 extends AOCPuzzle{
    private int days;
    public Day6(String day, int days) throws IOException {
        super(day);
        this.days = days;
    }

    public Day6(String answer, String fileName, int days) throws IOException {
        super(answer, fileName);
        this.days = days;
    }

    public Day6(String day, String answer, String fileName, int days) throws IOException {
        super(day, answer, fileName);
        this.days = days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String solve() {
        FishLoader fishLoader = new FishLoader();
        List<Integer> fishSet = fishLoader.load(getData().get(0));
        DayManager dayManager = new DayManager(days, fishSet);
        while (dayManager.isNotLastDay()) {
            dayManager.nextDay();
        }
        return String.valueOf(dayManager.getFishCount());
    }

    public static void main(String[] args) throws IOException {
        Day6 day6 = new Day6("day6", 80);
        System.out.printf("Total fish(1): %s", day6.solve());
        day6.setDays(256);
        System.out.printf("Total fish(2): %s", day6.solve());

    }

}
