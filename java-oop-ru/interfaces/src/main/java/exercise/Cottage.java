package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    public double getArea() {
        return area;
    }
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return  this.floorCount + " этажный коттедж площадью " + this.area + " метров";
    }
}
// END
