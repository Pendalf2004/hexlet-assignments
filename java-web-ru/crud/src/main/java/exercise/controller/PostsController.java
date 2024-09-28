package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void showPost(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    public static void showAllPosts(Context ctx) {
        int pageNum = 1;
        try {
            pageNum = Integer.parseInt(ctx.queryParam("page"));

        } catch (IllegalArgumentException e) {
            pageNum = 1;
        }
        finally {
            pageNum = Math.max(pageNum, 1);
            var posts = PostRepository.findAll(pageNum, 5);
            var page = new PostsPage(posts, pageNum);
            ctx.render( "posts/index.jte", model("page", page));
        }
    }

    // END
}
