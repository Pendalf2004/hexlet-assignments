@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
<body>
<a href="/">Home</a>    <a href="/users">Users list</a>
<form action="/users" method="post">
    <div>
        <label>
            Имя
            <input type="text" name="firstName" />
        </label>
    </div>
    <div>
        <label>
            Фамилия
            <input type="text" name="lastName" />
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" required name="email" />
        </label>
    </div>
    <div>
        <label>
            Пароль
            <input type="password" required name="password" />
        </label>
    </div>
    <input type="submit" value="Зарегистрировать" />
</form>
</body>
`
)