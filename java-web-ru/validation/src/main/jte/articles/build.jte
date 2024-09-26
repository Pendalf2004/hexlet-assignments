@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/articles" method="post">
    <div>
        <label>
            Article title
            <input type="text" name="title" value="${page.getArticleTitle()}" />
        </label>
    </div>
    <hr>
    <div>
        <input type="text" name="content" value="${page.getArticleText()}" />
    </div>
    <hr>
    <input type="submit" value="Post" />
</form>
`
)