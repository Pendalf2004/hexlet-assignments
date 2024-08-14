package exercise;

// BEGIN
class App {
    public static void printSquare(Circle circle) {
        try {
            if (circle.getRadius() < 0) {throw new NegativeRadiusException("");}
            System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException e) {

        }
        finally {
            System.out.println("Вычисление окончено");

        }


    }
}
// END
