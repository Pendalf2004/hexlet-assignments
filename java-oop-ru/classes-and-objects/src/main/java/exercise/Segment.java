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
        int middleX = (this.getBeginPoint().getX() + this.getEndPoint().getX()) / 2;
        int middleY = (this.getBeginPoint().getY() + this.getEndPoint().getY()) / 2;
        return new Point(middleX, middleY);
    }

}
// END
