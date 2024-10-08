@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
content = @`
    @if(!page.getError().isEmpty())
        <div>
            <h3>
                ${page.getError()}
            </h3>
        </div>
        @endif
<form action="${exercise.util.NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="login" name="name" />
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" />
</form>
`
)