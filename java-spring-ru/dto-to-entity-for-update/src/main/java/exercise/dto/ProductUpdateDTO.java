package exercise.dto;

import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class ProductUpdateDTO {
    private Long    id;
    private Integer price;
    private String  title;
}
// END
