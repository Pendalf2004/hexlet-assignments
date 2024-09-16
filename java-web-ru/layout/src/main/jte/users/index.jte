@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
stuff = @`
    <h3><strong><span style="color: #808080;">Спиок: </span></strong></h3>
    @for(var user : page.getUsers())
        <div><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></div>
    @endfor
`
)
