@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    @if(page.getMsg() != null)
        <p>${page.getMsg()}</p>
    @endif

    <main>
        <h1>Все статьи</h1>

        <table class="table table-striped">
            @for(var post : page.getPosts())
                <tr>
                    <td>
                        ${post.getId()}
                    </td>
                    <td>
                        ${post.getName()}
                    </td>
                    <td>
                        ${post.getBody()}
                    </td>
                </tr>
            @endfor
        </table>
    </main>
    </div>
`
)
