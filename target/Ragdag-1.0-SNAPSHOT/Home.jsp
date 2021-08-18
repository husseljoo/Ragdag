<%--
  Created by IntelliJ IDEA.
  User: husseljo
  Date: 8/18/21
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--<h2 id="firstName"><%= "Welcome to the Car Dealership" %></h2>--%>
<h2 id="firstName">Welcome to the Car Dealership</h2>
document.getElementById("message").innerHTML = "password do not match";

<form action="LoginServlet" method="post">
    <div class="container">
        <label>Username : </label>
        <input type="text" placeholder="Enter Username" name="username" required />
        <label>Password : </label>
        <input type="password" placeholder="Enter Password" name="password" required />
        <button type="submit" name="login" value="OK">Login</button>
    </div>
</form>


</body>
</html>
