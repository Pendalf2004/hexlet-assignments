package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
       }
    public List<String> buildApartmentsList(List<Home> objects, int n) {
        var sortedObjects = objects.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .toList();
        var result = new List<String>();
        for (var i = 0; i <= n; i++) {
            result.add(sortedObjects.get(i).toString());
        }
    }
}
// END
