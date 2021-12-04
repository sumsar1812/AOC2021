import java.util.List;
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
        int co2 = Integer.parseInt(getCO2(getData(), 0), 2);
        int oxygen = Integer.parseInt(getOxygen(getData(), 0), 2);
        System.out.println(gammaRate * epsilonRate);
        System.out.println(co2 * oxygen);
    }
    public String getCO2(List<String> currentData, int index) {
        if (currentData.size() == 1) {
            return currentData.get(0);
        }
        List<String> ones = currentData.stream().filter(i -> i.charAt(index) == '1').collect(Collectors.toList());
        List<String> zeros = currentData.stream().filter(i -> i.charAt(index) == '0').collect(Collectors.toList());
        if (ones.size() < zeros.size()) {
            if (index == currentData.get(0).length() - 1) {
                return ones.get(0);
            }
            return getCO2(ones, index + 1);
        } else {
            if (index == currentData.get(0).length() - 1) {
                return zeros.get(0);
            }
            return getCO2(zeros, index + 1);
        }
    }

    public String getOxygen(List<String> currentData, int index) {
        if (currentData.size() == 1) {
            return currentData.get(0);
        }
        List<String> ones = currentData.stream().filter(i -> i.charAt(index) == '1').collect(Collectors.toList());
        List<String> zeros = currentData.stream().filter(i -> i.charAt(index) == '0').collect(Collectors.toList());
        if (ones.size() >= zeros.size()) {
            if (index == currentData.get(0).length() - 1) {
                return ones.get(0);
            }
            return getOxygen(ones, index + 1);
        } else {
            if (index == currentData.get(0).length() - 1) {
                return zeros.get(0);
            }
            return getOxygen(zeros, index + 1);
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
