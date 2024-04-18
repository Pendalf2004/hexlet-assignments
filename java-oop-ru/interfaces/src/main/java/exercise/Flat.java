package exercise;

// BEGIN
public class Flat implements Home {

    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double blcArea, int floor) {
        this.area = area;
        this.balconyArea = blcArea;
        this.floor = floor;
    }
    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }
    @Override
    public int compareTo(Home compareObj) {
        if (this.getArea() == compareObj.getArea()) {return 0;}
        int result;
        result = this.getArea() > compareObj.getArea() ? 1 : -1;
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
