@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html lang="en">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>User list</title>
    </head>
<body>
<h1>${page.getUser().getId()} - ${page.getUser().getLastName()} ${page.getUser().getFirstName()}</h1>
<p>${page.getUser().getEmail()}</p>
</body>