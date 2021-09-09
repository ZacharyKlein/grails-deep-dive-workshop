<%--
  Created by IntelliJ IDEA.
  User: dev
  Date: 9/9/21
  Time: 11:43 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Newsletter Dashboard</title>
</head>

<body>

<h1>Dashboard</h1>

<sec:ifLoggedIn>
   <h2>Welcome <sec:loggedInUserInfo field="username" />!</h2>
</sec:ifLoggedIn>

<h2>All Subscribers</h2>
<table>
    <g:each in="${subscribers}" var="subscriber">
        <tr>
            <td>${subscriber.lastName}</td>
            <td>${subscriber.firstName}</td>
            <td>${subscriber.email}</td>
        </tr>
    </g:each>
</table>

<h2>Verified Subscribers</h2>
<table>
    <g:each in="${verifiedSubscribers}" var="subscriber">
        <tr>
            <td>${subscriber.lastName}</td>
            <td>${subscriber.firstName}</td>
            <td>${subscriber.email}</td>
        </tr>
    </g:each>
</table>

</body>
</html>