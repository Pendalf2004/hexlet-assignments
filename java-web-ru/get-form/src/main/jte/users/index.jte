@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>User list</title>
</head>

<body>
<h2>${page.getTerm()}</h2>
@if(page.getUsers().isEmpty())
    <p>No user data</p>
@else
    @for(var user : page.getUsers())
        <div>
            <h2><p>${user.getLastName()} ${user.getFirstName()}</p>></h2>
            <p>${user.getEmail()}</p>
            <hr>
        </div>
    @endfor
@endif
</body>
</html>