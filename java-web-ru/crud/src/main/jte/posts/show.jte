@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div>
        <a href="${NamedRoutes.postsPath()}">Все посты</a>
    </div>
    <hr>
    <div>
        <p>
            <h3>${page.getPost().getName()}</h3>
        </p>
            <hr>
        <p>
                ${page.getPost().getBody()}
        </p>
    </div>
`
)
