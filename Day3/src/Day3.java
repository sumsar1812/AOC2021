import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Day3 extends Day{

    public static void main(String[] args) {
        Day3 day3 = new Day3();
        day3.run();
    }

    public Day3() {
        super("day3");
    }

    @Override
    public void run() {
        int gammaRate;
        int epsilonRate;
        int dataLength = getData().get(0).length();
        StringBuilder gammaBits = new StringBuilder();
        StringBuilder epsilonBits = new StringBuilder();
        for (int i = 0; i < dataLength; i++) {
            gammaBits.append(getGammaBit(i));
            epsilonBits.append(getEpsilonRate(i));
        }
        gammaRate = Integer.parseInt(gammaBits.toString(), 2);
        epsilonRate = Integer.parseInt(epsilonBits.toString(), 2);
        BiPredicate<List<String>, List<String>> co2Predicate = (l1, l2) -> l1.size() < l2.size();
        BiPredicate<List<String>, List<String>> oxygenPredicate = (l1, l2) -> l1.size() >= l2.size();
        int co2 = Integer.parseInt(getCO2OrOxygen(getData(), co2Predicate,0), 2);
        int oxygen = Integer.parseInt(getCO2OrOxygen(getData(), oxygenPredicate,0), 2);
        System.out.println(gammaRate * epsilonRate);
        System.out.println(co2 * oxygen);
    }
    public String getCO2OrOxygen(List<String> currentData, BiPredicate<List<String>, List<String>> predicate, int index) {
        if (currentData.size() == 1) {
            return currentData.get(0);
        }
        List<String> ones = currentData.stream().filter(i -> i.charAt(index) == '1').collect(Collectors.toList());
        List<String> zeros = currentData.stream().filter(i -> i.charAt(index) == '0').collect(Collectors.toList());
        if (predicate.test(ones, zeros)) {
            return getCO2OrOxygen(ones, predicate, index + 1);
        } else {
            return getCO2OrOxygen(zeros, predicate, index + 1);
        }
    }

    public int getGammaBit(int characterIndex) {
        long ones = getData().stream().filter(i -> i.charAt(characterIndex) == '1').count();
        long needed = (getData().size() / 2) + getData().size() % 2;
        if (ones > needed) {
            return 1;
        }
        return 0;
    }
    public int getEpsilonRate(int characterIndex) {
        long ones = getData().stream().filter(i -> i.charAt(characterIndex) == '1').count();
        long needed = (getData().size() / 2) + getData().size() % 2;
        if (ones < needed) {
            return 1;
        }
        return 0;
    }

}
