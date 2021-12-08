import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day7 extends AOCPuzzle{
    private boolean gasConstant;

    public Day7(String day, boolean gasConstant) throws IOException {
        super(day);
        this.gasConstant = gasConstant;
    }

    public Day7(String answer, String fileName, boolean gasConstant) throws IOException {
        super(answer, fileName);
        this.gasConstant = gasConstant;
    }

    public String solve() {
        List<Integer> data = Arrays.stream(getData().get(0).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int avg = (int) data.stream().mapToInt(i -> i).average().orElse(0);
        GasManager gasManager = new GasManager();
        int last = gasManager.getGas(data, avg, gasConstant);
        int add = 1;
        int checkingAt = avg;
        final int next = gasManager.getGas(data, avg + 1, gasConstant);
        if (next > last) {
            add = -1;
        } else {
            checkingAt += 1;
            last = next;
        }

        do {
            final int gas = gasManager.getGas(data, checkingAt, gasConstant);
            if (gas > last) {
                return String.valueOf(last);
            }
            last = gas;
            checkingAt += add;
        } while (checkingAt != 0);

        return null;
    }

    public void setGasConstant(boolean gasConstant) {
        this.gasConstant = gasConstant;
    }

    public static void main(String[] args) throws IOException {
        Day7 day7 = new Day7("day7", true);
        System.out.println(day7.solve());
        day7.setGasConstant(false);
        System.out.println(day7.solve());
    }
}
