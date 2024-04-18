package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
       }
    public List<String> buildApartmentsList(List<Home> objects, int n) {
        var sortedObjects = objects.stream()
                .sorted((obj1, obj2) -> obj1.getArea().CompareTo(obj2.getArea()))
                .toList();
        var result = new List<String>[n];
        for (var i = 0; i <= n; i++) {
            result.add(sortedObjects.get(i).toString());
        }
    }
}
// END
