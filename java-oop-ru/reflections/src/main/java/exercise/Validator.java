package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class  Validator {
    public static List<String> validate(Address adress) {
        ArrayList<String> result = new ArrayList<>();
    for (Field field : adress.getClass().getDeclaredFields()) {
        if (field.getAnnotation(NotNull.class) != null) {
            try {
                field.setAccessible(true);
                if (field.get(adress) == null) {
                    result.add(field.getName());
                };
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            }
        }
    return result;
    }
}
// END
