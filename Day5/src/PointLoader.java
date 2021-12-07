import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class PointLoader {
    private final static Pattern pointPattern = Pattern.compile("(\\d+),(\\d+) -> (\\d+),(\\d+)");
    private final Set<Point> points = new HashSet<>();
    private final Set<Point> pointDuplicate = new HashSet<>();
    private int overlappingCount = 0;
    public void loadPoints(List<String> data) {
        data.forEach(this::loadPoint);
        System.out.println(pointDuplicate.size());
    }

    private void loadPoint(String input) {
        //593,10 -> 593,98
        Matcher matcher = pointPattern.matcher(input);
        if (matcher.matches()) {
            int x1 = Integer.parseInt(matcher.group(1));
            int y1 = Integer.parseInt(matcher.group(2));
            int x2 = Integer.parseInt(matcher.group(3));
            int y2 = Integer.parseInt(matcher.group(4));

            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);

            if (x1 != x2 && y1 != y2) {
                int xDiff = x1 - x2;
                int yDiff = y1 - y2;

                for (int i = 0; i <= Math.abs(yDiff); i++) {
                    int xTemp = x2 + i * (xDiff < 0 ? -1 : 1);
                    int yTemp = y2 + i * (yDiff < 0 ? -1 : 1);
                    Point point = new Point(xTemp, yTemp);
                    System.out.println(point);
                    if (points.contains(point)) {
                        pointDuplicate.add(point);
                    }
                    points.add(point);
                }
                return;
            }
            IntStream.rangeClosed(minX, maxX).forEach(x -> {
               IntStream.rangeClosed(minY, maxY).forEach(y -> {
                   Point point = new Point(x, y);
                   if (points.contains(point)) {
                       pointDuplicate.add(point);
                   }
                   points.add(point);
                   //linePoints.add(point);
               });
            });

        }

    }

}
