import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class Day {

    private List<String> data;

    public Day(String day) {
        try {
            data = Files.readAllLines(Paths.get( String.format("./%s/data/data.txt", day)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public abstract void run();

    public List<String> getData() {
        return data;
    }

}
