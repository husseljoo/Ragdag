<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>

<form action="login" method="post">
    <div class="container">
        <label>Username : </label>
        <input type="text" placeholder="Enter Username" name="username" required />
        <label>Password : </label>
        <input type="password" placeholder="Enter Password" name="password" required />
        <button type="submit" value="RUN">Login</button>
    </div>


<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="login">Login Servlet</a>

</body>
</html>