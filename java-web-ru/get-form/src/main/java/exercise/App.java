package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.stream.Collectors;

import exercise.model.User;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
                    String firstNameQuery = ctx.queryParams("term").toString();
                    firstNameQuery = firstNameQuery.substring(1, firstNameQuery.length() - 1);
                    var page = new UsersPage(USERS, firstNameQuery);
                    if ((firstNameQuery != null) && !firstNameQuery.isEmpty()) {
                        String finalFirstNameQuery = firstNameQuery;
                        page = new UsersPage(USERS.stream().
                                filter(user -> StringUtils.startsWithIgnoreCase(
                                        user.getFirstName(), finalFirstNameQuery))
                                .collect(Collectors.toList()), ctx.queryParams("term").toString());
                    }
                    ctx.render("users/index.jte", model("page", page));
                });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
