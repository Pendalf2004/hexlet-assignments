package exercise.dto;

import org.openapitools.jackson.nullable.JsonNullable;

import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class CarUpdateDTO {
    private JsonNullable<String> name;
    private JsonNullable<String> manufacturer;
    private JsonNullable<String> enginePower;
}
// END
