package exercise;

// BEGIN
public class Segment {
    private Point startsAt;
    private Point endsAt;

    public Segment(Point start, Point end) {
        this.startsAt = start;
        this.endsAt = end;
    }
    public Point getBeginPoint() {
        return this.startsAt;
    }
    public Point getEndPoint() {
        return this.endsAt;
    }
    public Point getMidPoint() {
        int middleX = (this.startsAt().getX() + this.startsAt().getY()) / 2;
        int middleY = (this.endsAt().getX() + this.endsAt().getY()) / 2;
        return new Point(middleX, middleY);
    }

}
// END
