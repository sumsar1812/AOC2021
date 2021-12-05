import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class PointLoader {
    private final static Pattern pointPattern = Pattern.compile("(\\d+),(\\d+) -> (\\d+),(\\d+)");
    private final List<Line> lines = new ArrayList<>();
    private int overlappingCount = 0;
    public void loadPoints(List<String> data) {
        data.forEach(this::loadPoint);
        System.out.println(overlappingCount);
    }

    private void loadPoint(String input) {
        //593,10 -> 593,98
        Matcher matcher = pointPattern.matcher(input);
        if (matcher.matches()) {
            int x1 = Integer.parseInt(matcher.group(1));
            int y1 = Integer.parseInt(matcher.group(2));
            int x2 = Integer.parseInt(matcher.group(3));
            int y2 = Integer.parseInt(matcher.group(4));
            Set<Point> linePoints = new HashSet<>();
            System.out.println(x1 + " - " + x2);
            System.out.println(y1 + " - " + y2);
            System.out.println();
            if (x1 != x2 && y1 != y2) {
                return;
            }
            IntStream.rangeClosed(Math.min(x1, x2), Math.max(x1, x2)).forEach(x -> {
               IntStream.rangeClosed(Math.min(y1, y2), Math.max(y1,y2)).forEach(y -> {
                   Point point = new Point(x, y);
                   linePoints.add(point);
               });
            });

            Line line = new Line(linePoints);

            if (lines.contains(line)) {
                overlappingCount++;
            }
            lines.add(line);
        }

    }

}
