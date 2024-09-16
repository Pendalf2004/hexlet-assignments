@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
stuff = @`
    <main>
        <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
        <p>${page.getUser().getEmail()}</p>
    </main>
`
)
