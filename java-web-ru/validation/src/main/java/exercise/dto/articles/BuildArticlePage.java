package exercise.dto.articles;

import io.javalin.validation.ValidationError;
import java.util.Map;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

// BEGIN
//@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildArticlePage {
    private String articleTitle;
    private String articleText;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildArticlePage(String title, String text, Map<String, List<ValidationError<Object>>> errors) {
    this.articleTitle = title;
    this.articleText = text;
    this.errors = errors;
    }
}
// END
