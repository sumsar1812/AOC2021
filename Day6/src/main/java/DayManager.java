import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class DayManager {
    private final static int NEWBORN_TIMER = 8;
    private final int maxDays;
    private Map<Integer, Long> fishMap;
    private int day;

    public DayManager(int maxDays, List<Integer> fishList) {
        this.maxDays = maxDays;
        this.fishMap = fishList.stream().collect(Collectors.groupingBy(identity(), counting()));
        //this.fishMap = fishMap.stream().collect(Collectors.groupingBy(identity(), counting()))
         //       .entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (v1, v2) -> v1));
    }

    public void nextDay() {
        this.day++;
        if (day % 10 == 0) {
            System.out.println("day: " + day + " - " + fishMap.size());
        }
        Map<Integer, Long> tmp = new HashMap<>();
        for (int i = 8; i >= 0; i--) {
            long count = fishMap.getOrDefault(i, 0L);
            if (count > 0) {
                tmp.put(i - 1, count);
            }
        }
        fishMap = tmp;


        long newborns = fishMap.getOrDefault(-1, 0L);
        fishMap.remove(-1);
        if (newborns > 0) {
            fishMap.put(NEWBORN_TIMER, newborns);
        }
        fishMap.merge(6, newborns, Long::sum);

    }
    public long getFishCount() {
        return fishMap.values().stream().reduce(Long::sum).orElse(0L);
    }

    public boolean isNotLastDay() {
        return this.day != this.maxDays;
    }

}
