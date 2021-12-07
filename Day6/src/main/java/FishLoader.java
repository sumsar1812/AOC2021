import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FishLoader {

    public List<Integer> load(String data) {
        return Arrays.stream(data.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}
