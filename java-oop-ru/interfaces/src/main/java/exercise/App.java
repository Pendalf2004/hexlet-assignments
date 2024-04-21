package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
       }
    public List<String> buildApartmentsList(List<Home> objects, int n) {
        return objects.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(n)
                .map(Home::toString)
                .toList();
        //var result = new ArrayList<String>();
        }
}
// END
