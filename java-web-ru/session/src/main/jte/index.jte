@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    <body>
    @if(page.getName() == null)
        <div>
            <a href="${NamedRoutes.loginPath()}">Войти</a>
        </div>

@else

    <div>
        <h2>
            ${page.getName().toString()}
        </h2>
        <hr>
        <form action="${NamedRoutes.logoutPath()}" method="post">
             <input type="submit" value="Выйти" />
        </form>
    </div>
    @endif
    </body>
`
)

