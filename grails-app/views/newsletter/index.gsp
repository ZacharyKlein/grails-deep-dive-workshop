<!DOCTYPE html>
<html>
<head>
<title>Subscribe to Newsletter</title>
</head>

<body>

<form method="post" action="/newsletter/subscribe">
    <fieldset>
        <ol>
            <li>
                <label for="name">First Name:</label>
                <input type="text" name="firstName" id="firstName">
            </li>
            <li>
               <label for="name">Last Name:</label>
               <input type="text" name="lastName" id="lastName">
            </li>
            <li>
                <label for="email">Email:</label>
                <input type="text" name="email" id="email">
            </li>
        </ol>
        <input type="submit" value="Submit"/>
    </fieldset>
</form>

</body>



</html>