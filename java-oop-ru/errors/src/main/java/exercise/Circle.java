package exercise;

// BEGIN
class Circle {
    final private Point center;
    final private int radius;

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getSquare() throws NegativeRadiusException {
        return 3.16 * radius * radius;
    }

    Circle(Point point, int radius) {
        this.center = point;
        this.radius = radius;
    }
}
// END
