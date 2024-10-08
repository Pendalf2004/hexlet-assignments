package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.NoSuchElementException;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {
        var name = ctx.cookie("hexLogged");
        var page = new MainPage(name);
        ctx.render("index.jte", model("page", page));
    }

    public static void logIn(Context ctx) {
        var name = ctx.cookie("hexLogged");
        var page = new LoginPage(name, "");
        ctx.render("build.jte", model("page", page));
    }

    public static void createSession(Context ctx) {
        String name = ctx.formParamAsClass("name", String.class).get();
        String password = ctx.formParamAsClass("password", String.class).get();
        if (name.isEmpty()||password.isEmpty()){
            var page = new LoginPage(null, "Enter user name and password");
            ctx.render("build.jte", model("page", page)).status(302);
        } else {
            try {
                var user = UsersRepository.findByName(name).get();
                if (user.getName().equals(name) && user.getPassword().equals(encrypt(password))) {
                    ctx.cookie("hexLogged", name);
                    var page = new MainPage(name);
                    ctx.render("index.jte", model("page", page)).status(302);
                } else {
                    var page = new LoginPage(null, "Wrong username or password");
                    ctx.render("build.jte", model("page", page)).status(302);
                }
            } catch (Exception e) {
                if (e instanceof NullPointerException) {
                    var page = new LoginPage(null, "Enter user name and password");
                    ctx.render("build.jte", model("page", page));
                }
                if (e instanceof NoSuchElementException) {
                    var page = new LoginPage(null, "Wrong username or password");
                    ctx.render("build.jte", model("page", page)).status(302);
                }

            }
        }
    }

    public static void logOut(Context ctx) {
        ctx.removeCookie("hexLogged");
        var page = new MainPage(null);
        ctx.render("index.jte", model("page", page)).status(302);
    }

    // END
}
