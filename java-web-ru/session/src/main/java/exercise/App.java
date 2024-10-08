package exercise;

import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get(NamedRoutes.buildSessionPath(), SessionsController::logIn);
        app.post(NamedRoutes.logoutPath(), SessionsController::logOut);
        app.post(NamedRoutes.loginPath(), SessionsController::createSession);
        app.get(NamedRoutes.rootPath(), SessionsController::root);
        app.get(NamedRoutes.loginPath(), SessionsController::logIn);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
