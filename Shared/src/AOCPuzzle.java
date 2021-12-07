import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class AOCPuzzle {

    private List<String> data;
    private String answer;

    public AOCPuzzle(String day) throws IOException {
        this("/" + day, null, "data.txt");
    }

    public AOCPuzzle(String answer, String fileName) throws IOException {
        this("", answer, fileName);
    }

    public AOCPuzzle(String day, String answer, String fileName) throws IOException {
        this.data = Files.readAllLines(Paths.get(String.format(".%s/data/%s", day, fileName)));
        this.answer = answer;
    }

    public abstract String solve();

    @Deprecated
    public void run(){

    }


    public List<String> getData() {
        return data;
    }

    public String getAnswer() {
        return answer;
    }

}
