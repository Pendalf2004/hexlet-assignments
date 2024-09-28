@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(

content = @`
    <hr>
    <h1>Posts</h1>
    <table class="table table-striped">
        @for(var post : page.getPosts())
            <div><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></div>
        @endfor
        <hr>
        <a href="${NamedRoutes.postsPath() + "?page=" + (page.getPageNum() - 1)}">Предыдущая страница</a> <a href="${NamedRoutes.postsPath() + "?page=" + (page.getPageNum() + 1)}">Следующая страница</a>
    </table>
`
)
