package exercise;

// BEGIN
class NegativeRadiusException extends RuntimeException {
    public NegativeRadiusException(String error) {
        System.out.println("Не удалось посчитать площадь");
    }
}
// END
