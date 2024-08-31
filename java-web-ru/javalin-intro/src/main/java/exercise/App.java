package exercise;

// BEGIN
import io.javalin.Javalin;
// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var web = Javalin.create();
        web.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
        // END
        return  web;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
