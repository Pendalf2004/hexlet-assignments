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
@Override
    public int compareTo(Home compareObj) {
        if (this.getArea() == compareObj.getArea()) {return 0;}
        int result;
        result = this.getArea() > compareObj.getArea() ? 1 : -1;
        return result;
    }
    @Override
    public double getArea() {
        return this.area;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return  this.floorCount + " этажный коттедж площадью " + this.area + " метров";
    }
}
// END
