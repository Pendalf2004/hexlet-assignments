package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN

        var web = Javalin.create();
        web.get("/phones", ctx -> ctx.json(Data.getPhones()));
        web.get("/domains", ctx -> ctx.json(Data.getDomains()));
        return web;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
