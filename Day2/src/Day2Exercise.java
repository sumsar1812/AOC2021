import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Day2Exercise {

    public static void main(String[] args) throws IOException {
        List<String> commands = Files.readAllLines(Paths.get("C:\\Users\\Rasmus\\IdeaProjects\\AOC\\Day2\\src\\data.txt"));
        final int[] h = {0};
        final int[] aim = {0};
        final int[] d = {0};
        Map<String, Consumer<Integer>> map = new HashMap<>();
        map.put("forward", i -> {
            h[0] += i;
            d[0] += i * aim[0];
        });
        map.put("up", i -> aim[0] -= i);
        map.put("down", i -> aim[0] += i);
        for (String command : commands) {
            String[] cmdSplit = command.split(" ");
            map.get(cmdSplit[0]).accept(Integer.parseInt(cmdSplit[1]));
        }
        System.out.println(d[0] * h[0]);
    }
}