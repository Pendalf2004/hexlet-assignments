package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.rendering.template.TemplateUtil;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void index(Context ctx) {
        var page = new PostsPage(PostRepository.getEntities());
        page.setMsg(ctx.consumeSessionAttribute("msg"));
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void create(Context ctx) {
        String title = ctx.formParam("name") == null ? "" : ctx.formParam("name");
        String text = ctx.formParam("body") == null ? "" : ctx.formParam("body");
        try {
            if (title.length() > 2) {
                ctx.sessionAttribute("msg", "Post was successfully created!");
                PostRepository.save(new Post(title, text));
                var page = new PostsPage(PostRepository.getEntities());
                ctx.redirect(NamedRoutes.postsPath());
            } else {
                var page = new PostsPage(PostRepository.getEntities());
                ctx.render("posts/index.jte", model("page", page)).status(302);
            }
        } catch (NullPointerException e) {
            //var page = new PostPage(new Post(title, text));
            var page = new PostsPage(PostRepository.getEntities());
            //ctx.render("posts/index.jte", model("page", page)).status(302);
        }
    }
        // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
