import java.util.Objects;
import java.util.Set;

public class Line {
    private final Set<Point> points;

    public Line(Set<Point> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        /*if (line.points.size() == 0) {
            return false;
        }*/
        return this.points.containsAll(line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
