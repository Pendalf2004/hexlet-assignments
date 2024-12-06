package exercise.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class PostDTO {
    private Long                id;
    private List<CommentDTO>    comments;
    private String              title;
    private String              body;
}
// END
