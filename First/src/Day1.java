import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) throws IOException {
        List<Integer> dataList = Files.readAllLines(Paths.get("C:\\Users\\Rasmus\\IdeaProjects\\AOC\\First\\src\\data.txt"))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> newData = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            int result = 0;
            for (int k = i; k < 3 + i; k++) {
                if (k >= dataList.size()) {
                    continue;
                }
                result += dataList.get(k);
            }
            newData.add(result);
        }
        int total = 0;
        Integer prev = null;
        for (Integer data : newData) {
            if (prev == null) {
                prev = data;
                continue;
            }
            if (data > prev) {
                total++;
            }
            prev = data;
        }
        System.out.println(total);
    }
}
