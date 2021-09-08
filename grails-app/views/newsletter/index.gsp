<!DOCTYPE html>
<html>
<head>
    <title>Subscribe to Newsletter</title>
</head>

<body>

<g:if test="${message}">
    <h1>${message}</h1>
</g:if>
<g:else>
    <h1>Subscribe Form</h1>
</g:else>

<g:render template="subscribeForm" model="[message: message]" />

</body>

</html>